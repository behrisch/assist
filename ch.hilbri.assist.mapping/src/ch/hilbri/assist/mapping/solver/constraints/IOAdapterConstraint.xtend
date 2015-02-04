package ch.hilbri.assist.mapping.solver.constraints

import ch.hilbri.assist.datamodel.model.AssistModel
import ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType
import ch.hilbri.assist.datamodel.model.IOAdapterProtectionLevelType
import ch.hilbri.assist.datamodel.model.IOAdapterType
import ch.hilbri.assist.mapping.solver.variables.SolverVariablesContainer
import java.util.ArrayList
import org.chocosolver.solver.Solver
import org.chocosolver.solver.constraints.ICF
import org.chocosolver.solver.exception.ContradictionException
import org.chocosolver.solver.variables.BoolVar
import org.chocosolver.solver.variables.VF
import ch.hilbri.assist.mapping.solver.exceptions.BasicConstraintsException

class IOAdapterConstraint extends AbstractMappingConstraint {
	
	new(AssistModel model, Solver solver, SolverVariablesContainer solverVariables) {
		super("I/O adapter constraints", model, solver, solverVariables)
	}

	override generate() {
		generate_SingleThread_ExclusiveRequests_incl_ProtectionLevel_Constraints()
		generate_MultipleTheads_ExclusiveRequests_incl_ProtectionLevel_Constraints()
		
		try {
			solver.propagate()
		}
		catch (ContradictionException e) {
			throw new BasicConstraintsException(name)
		}
		return true
	}
	
	def generate_MultipleTheads_ExclusiveRequests_incl_ProtectionLevel_Constraints() {
		
		for (b : model.allBoards) {
			/* Contains a boolean factor for the weighted sum - is this thread mapped to this board? 
			 * The index of this list corresponds to the thread index 
			 * factorList[thread] = true/false <-- is this thread mapped to board b? */
			val factorList = new ArrayList<BoolVar>
		
			for (t : model.allThreads) {
				
				val threadLocationsBoardLevel 	= solverVariables.getThreadLocationVariable(t, HardwareArchitectureLevelType.BOARD_VALUE)
				val delta 						= VF.bool("d2-" + t.name + "-" + b.name, solver)
				val constraint					= ICF.arithm(threadLocationsBoardLevel, "=", model.allBoards.indexOf(b))
				constraint.reifyWith(delta) 
				
				factorList.add(delta)
			}
			
			for (type : IOAdapterType.values) {
				for (level : IOAdapterProtectionLevelType.values) {

					// how many adapters does this board have for the type and level
					val suiteableIOAdapterCountVar	= VF.enumerated("SuiteableIOAdapterCount-"+b.name+"-"+type+"-"+level, 0, b.getSuitableAdapterCount(type, level), solver)

					// how many io requests with the given type and minimum protection level does each thread require?
					val requestCountForEachThreadWithProtectionLevelAndType = model.allThreads.map[getExclusiveAdapterRequestCount(type, level)]

					// Define the sum to constrain the deployment
					solver.post(ICF.scalar(factorList, requestCountForEachThreadWithProtectionLevelAndType, "=", suiteableIOAdapterCountVar))
				}	
			}
		}
		
	}
	
	def generate_SingleThread_ExclusiveRequests_incl_ProtectionLevel_Constraints() {

		for (t : model.allThreads) {
			for (exReq : t.application.ioAdapterRequirements.filter[isIsExclusiveOnly]) {
		
				// Create a list for each board with the number of suitable adapters which satisfy type and protection level
				// suiteableAdapterCountPerBoardList[board] = # suiteable adapters w.r.t. type and protection level
				val suiteableAdapterCountPerBoardList = model.allBoards.map[getSuitableAdapterCount(exReq.adapterType, t.application.ioAdapterProtectionLevel)]
				
				// Create a new variable with these values as a default domain
				val suiteableAdapterCountPerBoardVariable = VF.enumerated("IOVar-"+t.name+"-"+exReq.adapterType+"-"+t.application.ioAdapterProtectionLevel, suiteableAdapterCountPerBoardList.sort, solver)

				/* To which board can we map this thread? */
				val threadLocationsBoardLevel = solverVariables.getThreadLocationVariable(t, HardwareArchitectureLevelType.BOARD_VALUE)
		
				// Link the location variables to the adapterCountVariable
				solver.post(ICF.element(suiteableAdapterCountPerBoardVariable, suiteableAdapterCountPerBoardList, threadLocationsBoardLevel))
				
				// Impose constraints on the adapterCountVariable
				solver.post(ICF.arithm(suiteableAdapterCountPerBoardVariable, ">=", exReq.requiredAdapterCount))
			}			
		}	
	}
		
}