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

import solver.Solver;
import solver.exception.ContradictionException;
import solver.search.loop.monitors.SMF;
import solver.search.solution.AllSolutionsRecorder;
import solver.search.strategy.IntStrategyFactory;
import solver.search.strategy.selectors.values.IntDomainMin;
import solver.search.strategy.selectors.variables.InputOrder;
import solver.variables.IntVar;
import ch.hilbri.assist.datamodel.model.AssistModel;
import ch.hilbri.assist.datamodel.result.mapping.Result;
import ch.hilbri.assist.mapping.result.ResultFactoryFromSolverSolutions;
import ch.hilbri.assist.mapping.solver.constraints.AbstractMappingConstraint;
import ch.hilbri.assist.mapping.solver.variables.SolverVariablesContainer;
import ch.hilbri.assist.mapping.ui.multipageeditor.MultiPageEditor;
import ch.hilbri.assist.mapping.ui.multipageeditor.resultsview.model.DetailedResultsViewUiModel;

public class SolverJob extends Job {

	private AssistModel model;
	
	private Solver solver;

	private SolverVariablesContainer solverVariables;
	
	private ArrayList<AbstractMappingConstraint> mappingConstraintsList;

	private DetailedResultsViewUiModel detailedResultsViewUiModel;
		
	private MultiPageEditor multiPageEditor;
	
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
			multiPageEditor = editor;
			detailedResultsViewUiModel = multiPageEditor.getDetailedResultViewUiModel();
			detailedResultsViewUiModel.setEditor(multiPageEditor);
		}

		/* Create a list for the results */ 
		this.mappingResults = new ArrayList<Result>();  
	
		/* Create an empty set of constraints that will be used */
		this.mappingConstraintsList = new ArrayList<AbstractMappingConstraint>();
		
		/* Create a new Solver object */
		this.solver = new Solver();
		this.solverVariables = new SolverVariablesContainer(this.model, solver);
		
		/* Create a new Constraint to process the system hierarchy */
//		this.mappingConstraintsList.add(new SystemHierarchyConstraint(model, constraintStore, solverVariables));

		/* Create a new constraint to keep the capacity of the cores */
//		this.mappingConstraintsList.add(new CoreUtilizationConstraint(model, constraintStore, solverVariables));

		/* Create a new set of constraints to watch for the RAM capacity of the boards */
//		this.mappingConstraintsList.add(new RAMUtilizationConstraint(model,  constraintStore, solverVariables));
		
		/* Create a new set of constraints to watch for the ROM capacity of the boards */
//		this.mappingConstraintsList.add(new ROMUtilizationConstraint(model,  constraintStore, solverVariables));
		
		/* Create a new constraint to avoid permuting solutions */
//		this.mappingConstraintsList.add(new NoPermutationsConstraint(model, constraintStore, solverVariables));

		/* Create a new Constraint to keep threads of the same application on the same board. */
//		this.mappingConstraintsList.add(new AllApplicationThreadsOnSameBoard(model, constraintStore, solverVariables));
		
		/* Create a new Constraint for all i/o adapters (exclusive, shared, protection level, ...) */
//		this.mappingConstraintsList.add(new IOAdapterConstraint(model, constraintStore, solverVariables));
		
		/* Create a new Constraint for the design assurance level compatibility of boards and threads */
//		this.mappingConstraintsList.add(new DesignAssuranceLevelConstraint(model, constraintStore, solverVariables));
		
		/* Create a new constraint that restricts the applications to their specified hardware elements */
//		this.mappingConstraintsList.add(new RestrictedDeploymentConstraint(model, constraintStore, solverVariables));
		
		/* Create a new constraint to restrictions on the proximity of the applications */
//		this.mappingConstraintsList.add(new ApplicationProximityConstraint(model, constraintStore, solverVariables));
		
		/* Create a new constraint to obey the dislocality requirements */
//		this.mappingConstraintsList.add(new DislocalityConstraint(model, constraintStore, solverVariables));
		
//		/* new */
//		this.mappingConstraintsList.add(new DissimilarityTreeConstraint(this.constraintSystem, this.model, this.threadVariablesList));
//		
//		/* Create new constraints to keep the applications on the networks */
//		this.mappingConstraintsList.add(new CommunicationOnNetworkConstraint(constraintSystem, model, threadVariablesList, communicationVariablesList));

	}

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
			
			boolean  contradiction = false;
			
			try {
				solver.propagate();
			} catch (ContradictionException e) {
				contradiction = true;
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
			}
			
			if (contradiction) return Status.CANCEL_STATUS;

			else monitor.worked(1);
		}

		
		monitor.subTask("Searching for solutions");
		if (runSearchForSolutions(monitor) != Status.OK_STATUS) return Status.CANCEL_STATUS;
		monitor.worked(1);
		 
		if (presentResults == true) { 
			 monitor.subTask("Showing results");
			 showResults(mappingResults);
			 monitor.worked(1);
		}
		 
		return Status.OK_STATUS;
	}

	
	
	
	
	private IStatus runSearchForSolutions(IProgressMonitor monitor) {
		
		AllSolutionsRecorder recorder = new AllSolutionsRecorder(solver);
		solver.set(recorder);
		
		if (this.kindOfSolutions == SearchType.CONSECUTIVE) {
			
			SMF.limitSolution(solver, this.maxSolutions);
			SMF.limitTime(solver, 60 * 60 * 1000); // 1h max runtime

			solver.set(IntStrategyFactory.custom(new InputOrder<IntVar>(), new IntDomainMin(), solverVariables.getAllVariables()));
		}

		else {
			// FIXME: Implement me!
			SMF.limitTime(solver, this.maxTimeOfCalculationInmsec);
			return null;
		}
		
		solver.findAllSolutions();
		
		mappingResults = ResultFactoryFromSolverSolutions.create(model, solverVariables, recorder.getSolutions());
		
		return Status.OK_STATUS;
	}
	
	/**
	 * Show the results in the UI
	 * 
	 * @param allResults
	 *            
	 */
	private void showResults(final ArrayList<Result> allResults) {		
		
		detailedResultsViewUiModel.setResultsList(allResults);
		detailedResultsViewUiModel.indexToDrawProperty().set(0);
		
		
		if (multiPageEditor != null) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {	multiPageEditor.setActiveResultPage();	}
			});
		}
	}

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