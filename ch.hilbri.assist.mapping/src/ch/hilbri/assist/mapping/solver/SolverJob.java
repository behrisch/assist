package ch.hilbri.assist.mapping.solver;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.IndomainMin;
import org.jacop.search.InputOrderSelect;
import org.jacop.search.Search;
import org.jacop.search.SelectChoicePoint;

import ch.hilbri.assist.application.helpers.ConsoleCommands;
import ch.hilbri.assist.mapping.result.ResultFactoryFromSolverSolutions;
import ch.hilbri.assist.mapping.solver.constraints.AbstractMappingConstraint;
import ch.hilbri.assist.mapping.solver.constraints.SystemHierarchyConstraint;
import ch.hilbri.assist.mapping.solver.variables.SolverVariablesContainer;
import ch.hilbri.assist.mapping.ui.multipageeditor.MultiPageEditor;
import ch.hilbri.assist.mapping.ui.multipageeditor.resultsview.model.DetailedResultsViewUiModel;
import ch.hilbri.assist.model.AssistModel;
import ch.hilbri.assist.result.mapping.Result;

public class SolverJob extends Job {

	private AssistModel model;
	
	private Store constraintStore;
	
	private SolverVariablesContainer solverVariables;
	
	private ArrayList<AbstractMappingConstraint> mappingConstraintsList;

	private DetailedResultsViewUiModel detailedResultsViewUiModel;
		
//	private MultiPageEditor multiPageEditor;
	
	 /*
	 * Dieser Wert definiert eine maximale Anzahl an Deployments, die
	 * gesucht werden. Falls die Grenze ueberschritten wird, wird die
	 * Suche abgebrochen. Dann kann es sein, dass noch weitere Loesungen
	 * vorhanden sind, aber nicht gefunden worden sind.
	 */
	private int maxSolutions;
	

	/*
	 * Gibt an, welche Art der Suche verwendet werden soll:
	 * RANDOM: 		sucht zufaellig im gesamten Loesungsraum
	 * 		   		(Vorteil: Loesungen stammen aus allen Teilen des Loesungsraums)
	 * CONSECUTIVE: sucht "hintereiander" liegende Loesungen
	 * 				(Vorteil: Es kann eindeutig bestimmt werden, ob alle moeglichen Loesungen gefunden wurden)
	 */
	private SearchType kindOfSolutions;

	/*
	 * Im Advances Mode gibt dies die maximale Suchzeit an, da nicht
	 * festgestellt werden kann, ob alle existierenden Loesungen gefunden wurden.
	 */
	private long maxTimeOfCalculationInmsec;  // in msec
	
	
	private ArrayList<Result> mappingResults;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param model
	 * @param editor 
	 */
	public SolverJob(String name, AssistModel model, MultiPageEditor editor) {
		super(name);
		this.model = model;

		if (editor != null) {
//			this.multiPageEditor = editor;
			this.detailedResultsViewUiModel = editor.getDetailedResultViewUiModel();
			detailedResultsViewUiModel.setEditor(editor);
		}
		

		/* Create a list for the results */ 
		this.mappingResults = new ArrayList<Result>();  
	
		/* Create an empty set of constraints that will be used */
		this.mappingConstraintsList = new ArrayList<AbstractMappingConstraint>();
		
		/* Create a new Constraint Store (JaCoP) */
		this.constraintStore = new Store();
		this.solverVariables = new SolverVariablesContainer(this.model, constraintStore);
		
		
//		/* Create the set of Variables needed for a Thread */
//		this.threadVariablesList = new ThreadVariablesList(model, constraintSystem);
//		
//		this.coreVariablesList = new CoreVariablesList(model);
//		
//		this.exclusiveAdapterVariablesList = new ExclusiveAdapterRequirementVariablesList(model, this.threadVariablesList);
//		
//		this.sharedAdapterVariablesList = new SharedAdapterRequirementVariablesList(model, this.threadVariablesList);
//		
//		this.communicationVariablesList = new CommunicationVariablesList(model, constraintSystem);
//		
//		this.ioAdapterVariablesList = new IOAdapterVariablesList(model, constraintSystem);
		
		
		
		
		
		/* Create a new Constraint to process the system hierarchy */
		this.mappingConstraintsList.add(new SystemHierarchyConstraint(model, constraintStore, solverVariables));


		
//		/* Create a new Constraint to process the I/O-adapter to board hierarchy */
//		this.mappingConstraintsList.add(new IOAdapterHierarchyConstraint(this.constraintSystem, this.model, this.threadVariablesList,
//				this.exclusiveAdapterVariablesList, this.sharedAdapterVariablesList, ioAdapterVariablesList));
//		
//		/* Create a new Constraint to keep threads of the same application on the same board. */
//		this.mappingConstraintsList.add(new IdenticalThreadsOnSameBoardConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//
//		/* Create a new constraint to keep the criticality level of the threads regarding to the assurance level of the boards */
//		this.mappingConstraintsList.add(new CriticalityRequirementsConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create a new constraint to keep the capacity of the cores */
//		this.mappingConstraintsList.add(new CoreUtilizationConstraint(this.constraintSystem, this.model, this.threadVariablesList, coreVariablesList));
//
//		/* Create a new constraint to obey the restrictions on the proximity of the applications */
//		this.mappingConstraintsList.add(new ProximityRelationsConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create a new constraint to obey the dislocality and dissimilarity requirements */
//		this.mappingConstraintsList.add(new DislocalityConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		/* new */
//		this.mappingConstraintsList.add(new DissimilarityTreeConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create a new constraint to keep the RAM capacity of the boards */
//		this.mappingConstraintsList.add(new RAMCapacityConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create a new constraint to keep the ROM capacity of the boards */
//		this.mappingConstraintsList.add(new ROMCapacityConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create new constraints to keep the required adapters of the board (shared/exclusive) */
//		for (IOAdapterType adapterType : IOAdapterType.values()){
//			if ( !exclusiveAdapterVariablesList.get(adapterType.ordinal()).isEmpty() || !sharedAdapterVariablesList.get(adapterType.ordinal()).isEmpty() )
//				this.mappingConstraintsList.add(new IOAdapterConstraint(this.constraintSystem, this.model, this.threadVariablesList,
//																		this.ioAdapterVariablesList,  this.exclusiveAdapterVariablesList,
//																		this.sharedAdapterVariablesList, adapterType.toString(), adapterType));
//		}
//		
//		/* Create new constraints to keep the applications on the networks */
//		this.mappingConstraintsList.add(new CommunicationOnNetworkConstraint(constraintSystem, model, threadVariablesList, communicationVariablesList));
//		
//		/* Create a new constraint to avoid permuting solutions */
//		this.mappingConstraintsList.add(new NoPermuationsConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create a new constraint that restricts the applications to their specified ones */
//		this.mappingConstraintsList.add(new RestrictedHardwareComponentsConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//
	}
//
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		return execute(monitor, true);
	}
	
	/* Die Funktionalitaet der RUN-Methode wurde ausgelagert, um den Zugang fuer einen Test zu ermoeglichen */
	public IStatus execute(IProgressMonitor monitor, boolean presentResults) 
	{
		monitor.beginTask("Generating all mappings", 1);

		for (AbstractMappingConstraint constraint : mappingConstraintsList) {

			if (monitor.isCanceled()) return Status.CANCEL_STATUS;

			monitor.subTask("Processing constraint: \""	+ constraint.getName() + "\"");
			
			/* Generate this constraint */
			constraint.generate();
			
			/* Check the store for consistency so far */
			if (constraintStore.consistency() == false) {
				final String constraintName = constraint.getName();
				
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
						MessageDialog.openError(activeShell,
										"Specification inconsistencies",
										"Your specifications have been inconsistent.\n"
												+ "I was unable to generate a valid solution.\n\n"
												+ "Here is the last set of constraints which failed to propagate:\n\n"
												+ ">" + constraintName + "<");
					}
				});
				
				return Status.CANCEL_STATUS;
			} 
			
			else 
				monitor.worked(1);
		}

		 monitor.subTask("Searching for solutions");
		 if (runSearchForSolutions(monitor) != Status.OK_STATUS) 
			 return Status.CANCEL_STATUS;
		 monitor.worked(1);

	
		 monitor.subTask("Showing results");
//		 if (presentResults == true) { showResults(newMappingResults); }
		 monitor.worked(1);

		 return Status.OK_STATUS;
	}

	private IStatus runSearchForSolutions(IProgressMonitor monitor) {
		 
		SelectChoicePoint<IntVar> select;
		Search<IntVar> search;
		
		if (this.kindOfSolutions == SearchType.CONSECUTIVE) {
			search = new DepthFirstSearch<IntVar>();
			search.getSolutionListener().searchAll(true);
			search.getSolutionListener().recordSolutions(true);
			search.getSolutionListener().setSolutionLimit(this.maxSolutions);
				
			select = new InputOrderSelect<IntVar>(constraintStore, solverVariables.getSolutionVariables(), new IndomainMin<IntVar>());
		}
		else {
			search = new DepthFirstSearch<IntVar>();
			search.setTimeOut(this.maxTimeOfCalculationInmsec);
			ConsoleCommands.writeLineToConsole("Random search is not yet implemented.");
			return null;
		}
		 
		boolean result = search.labeling(constraintStore, select); 
		
		if (result) {
			ConsoleCommands.writeLineToConsole("Solutions found: " + search.getSolutionListener().solutionsNo() + " - Limit was set to " + this.maxSolutions + " - was it reached? " + search.getSolutionListener().solutionLimitReached());
			mappingResults = ResultFactoryFromSolverSolutions.create(model, solverVariables, search.getSolutionListener().getSolutions());
						
		}
		else
			ConsoleCommands.writeErrorLineToConsole("Nothing found");
		
		return Status.OK_STATUS;
		
//		/*
//		 * Sort the threadVariableList with respect to e.g. 'criticality', 'core utilization'
//		 * with highest value first. For multiple criteria begin sorting with most important
//		 * and end with less important criterion.
//		 */
//		Collections.sort(this.threadVariablesList, ThreadVariables.ThreadVariablesComparator.
//				decending(ThreadVariables.ThreadVariablesComparator.getComparator(
//				ThreadVariables.ThreadVariablesComparator.MAX_DOMAINS_REDUCTION_FIRST,
//				ThreadVariables.ThreadVariablesComparator.MAX_EXCLUSIVE_ADAPTER_REQUIREMENT_FIRST,
//				ThreadVariables.ThreadVariablesComparator.MAX_SHARED_ADAPTER_REQUIREMENT_FIRST,
//				ThreadVariables.ThreadVariablesComparator.MAX_ROM_UTILIZATION_FIRST,
//				ThreadVariables.ThreadVariablesComparator.MAX_RAM_UTILIZATION_FIRST,
//				ThreadVariables.ThreadVariablesComparator.HIGHEST_CRITICALITY_FIRST,
//				ThreadVariables.ThreadVariablesComparator.MAX_CORE_UTILIZATION_FIRST
//				)));
//		
//		/*
//		 * Create the set of solution variables - what are we interested in
//		 * solving? It is a subset of the threadVariables
//		 */
//		this.solutionVariablesList = new SolutionVariablesList(
//				this.threadVariablesList,
//				this.communicationVariablesList,
//				this.ioAdapterVariablesList,
//				this.exclusiveAdapterVariablesList,
//				this.sharedAdapterVariablesList);
//
//
//		
//		try {
//			if (maxSolutions > 0 && kindOfSolutions != null && maxTimeOfCalculationInmsec > 0)
//				return SolutionGenerator.generateSolutions(model, constraintSystem,
//						threadVariablesList, communicationVariablesList, ioAdapterVariablesList,
//						exclusiveAdapterVariablesList, sharedAdapterVariablesList, solutionVariablesList,
//						newMappingResults, maxSolutions, kindOfSolutions, maxTimeOfCalculationInmsec, monitor);
////			else
////				return SolutionGenerator.generateSolutions(model, constraintSystem, threadVariablesList, solutionVariablesList, mappingResults, monitor);
//			return null;
//		} catch (UninstantiatedException e) {
//			// wird geworfen, wenn solutionVariablen nicht eindeutig belegt wurden
//			e.printStackTrace();
//			System.err.println("FATAL ERROR: SolutionGenerator didn't set the variables to unique values!");
//			return Status.CANCEL_STATUS;
//		}
	}
//	
//	
//	/**
//	 * Zeigt die fertigen Resultate in der UI an.
//	 * 
//	 * @param allResults
//	 *            die Resultate / L�sungen f�r das Mapping Problem
//	 */
//	private void showResults(final ArrayList<Result> allResults) {		
//		// update the new UI
//		
//		detailedResultsViewUiModel.indexToDrawProperty().set(0);
//		detailedResultsViewUiModel.setResultsList(allResults);
//		
//		if (multiPageEditor != null) {
//			Display.getDefault().asyncExec(new Runnable() {
//				@Override
//				public void run() {	multiPageEditor.setActiveResultPage();	}
//			});
//		}
//	}
//	
//
//	
	/**
	 * Sets the maximum number of solution.
	 * @param maxSolutions
	 */
	public void setMaxSolutions(int maxSolutions) {
		this.maxSolutions = maxSolutions;
	}

	/**
	 * Sets the searching mode. See {@link SolutionGenerator.KindOfSolutions}
	 * @param kindOfSolutions
	 */
	public void setKindOfSolutions(SearchType kindOfSolutions) {
		this.kindOfSolutions = kindOfSolutions;
	}

	/**
	 * Sets the maximum time for the search in advanced mode.
	 * @param maxTimeOfCalculationInmsec
	 */
	public void setMaxTimeOfCalculationInmsec(long maxTimeOfCalculationInmsec) {
		this.maxTimeOfCalculationInmsec = maxTimeOfCalculationInmsec;
	}

	/**
	 * @return the newMappingResults
	 */
	public ArrayList<Result> getNewMappingResults() {
		return mappingResults;
	}
	
}