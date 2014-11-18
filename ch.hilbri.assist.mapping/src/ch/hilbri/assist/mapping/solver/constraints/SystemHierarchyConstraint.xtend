package ch.hilbri.assist.mapping.solver.constraints

import ch.hilbri.assist.datamodel.model.AssistModel
import ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType
import ch.hilbri.assist.mapping.solver.variables.SolverVariablesContainer
import solver.Solver
import solver.constraints.ICF

/**
 * Ziel: Zwischen allen Abstraktionsebenen im Modell muessen Verbindungen hergestellt werden.
 */
class SystemHierarchyConstraint extends AbstractMappingConstraint {
	
	new(AssistModel model, Solver solver, SolverVariablesContainer solverVariables) {
		super("System Hierarchy Constraints", model, solver, solverVariables)
	}
	
	override generate() {
		
		/* Wir brauchen einen "Link" zwischen allen Hardware-Ebenen */
		for (levelCtr : HardwareArchitectureLevelType.CORE_VALUE .. model.hardwareLevelCount - 1) {

			/* HardwareLevelLink ist ein Feld von Indizes der Parent-Komponenten 		
			 * hardwareLevelLink[KindIndex] = Parent_Index
			 *
			 * Beispiel: 
			 * - f�r die Verkn�pfung von Cores und Prozessoren wird ein Link zwischen Ebene 1 und 2 ben�tigt
			 * - die liste hardwareLevelLink enthaelt so viele Element, wie es Cores im Modell gibt
			 * - f�r jeden Core wird der Index des Parents (= Prozessor) eingetragen
			 */ 
			
			val hardwareLevelLink = model.getAllHardwareElements(levelCtr)
										.map[eContainer]   											// get the parent object
										.map[model.getAllHardwareElements(levelCtr+1).indexOf(it)] 	// get the parent index 
			
//			new ArrayList<Integer>
//			for (childHardwareComponent : model.getAllHardwareElements(levelCtr)) {
//				val parentHardwareComponent = childHardwareComponent.eContainer
//				hardwareLevelLink.add(model.getAllHardwareElements(levelCtr+1).indexOf(parentHardwareComponent)+1)
//			}
			
			/*
			 * Nun werden die Location Variablen eines Threads zwischen den Ebenen mit einem Element Constraint verkn�pft;
			 * Sollte damit beispielweise ein Prozessor als L�sung ausfallen, so werden automatisch auch die Kerne des 
			 * Prozessors aus dem L�sungsraum entfernt (und umgedreht)
			 */
			for (t : model.allThreads) {
				var index  = solverVariables.getThreadLocationVariable(t, levelCtr)
				var values = solverVariables.getThreadLocationVariable(t, levelCtr + 1)
				solver.post(ICF.element(values, hardwareLevelLink, index))
//				constraintStore.impose(new Element(index, hardwareLevelLink, values))
			}			
		} 
		
		return true
	}
	
}