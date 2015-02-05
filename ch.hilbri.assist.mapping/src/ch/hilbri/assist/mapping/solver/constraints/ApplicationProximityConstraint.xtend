package ch.hilbri.assist.mapping.solver.constraints

import ch.hilbri.assist.datamodel.model.Application
import ch.hilbri.assist.datamodel.model.ApplicationGroup
import ch.hilbri.assist.datamodel.model.AssistModel
import ch.hilbri.assist.datamodel.model.Thread
import ch.hilbri.assist.mapping.solver.variables.SolverVariablesContainer
import java.util.ArrayList
import org.chocosolver.solver.Solver
import org.chocosolver.solver.constraints.ICF
import org.chocosolver.solver.variables.IntVar

class ApplicationProximityConstraint extends AbstractMappingConstraint {
	
	new(AssistModel model, Solver solver, SolverVariablesContainer solverVariables) {
		super("application proximity (on same)", model, solver, solverVariables)
	}
	
	override generate() {
		
		for (relation : model.proximityRelations) {
			
			val level = relation.hardwareLevel
			
			val threadList = new ArrayList<Thread>()
			for (aog : relation.applicationsOrGroups) 
				if (aog instanceof ApplicationGroup) threadList.addAll((aog as ApplicationGroup).allThreads)
				else if (aog instanceof Application) threadList.addAll((aog as Application).threads)
				else return false
			
			
			val threadVarList = new ArrayList<IntVar>()
			for (t : threadList) threadVarList.add(solverVariables.getThreadLocationVariable(t, level.value))
			
			if (threadVarList.size > 1) 
				for (var i = 0; i < threadVarList.size - 1; i++ ) 
					solver.post(ICF.arithm(threadVarList.get(i), "=", threadVarList.get(i+1)))
			
		
			propagate()
		}

		return true
	}
	
}