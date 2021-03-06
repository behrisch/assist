package ch.hilbri.assist.mapping.ui.handlers;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.e4.compatibility.CompatibilityEditor;

import ch.hilbri.assist.application.helpers.ConsoleCommands;
import ch.hilbri.assist.application.helpers.Helpers;
import ch.hilbri.assist.datamodel.model.AssistModel;
import ch.hilbri.assist.mapping.datamodel.PostProcessor;
import ch.hilbri.assist.mapping.solver.SearchType;
import ch.hilbri.assist.mapping.solver.GuiSolverJob;
import ch.hilbri.assist.mapping.ui.multipageeditor.MultiPageEditor;
import ch.hilbri.assist.mapping.ui.searchtypesdialog.SimpleOrAdvancedModeDialog;


@SuppressWarnings("restriction")
public class Generate {

	@CanExecute
	public boolean canExecute(MApplication application, EModelService service) {
		MPart editorPart = Helpers.getActiveEditor(application, service);
		if (editorPart == null) return false;
		
		if (editorPart.getObject() instanceof CompatibilityEditor) {
			CompatibilityEditor compEditor = (CompatibilityEditor) editorPart.getObject();
			if (compEditor.getEditor() instanceof MultiPageEditor) {
				MultiPageEditor editor = (MultiPageEditor) compEditor.getEditor();
				IEditorInput input = editor.getEditorInput();
				if (input instanceof IFileEditorInput) {
					IPath path = ((IFileEditorInput)input).getFile().getLocation();
					URI uri = URI.createFileURI(path.toOSString());
					ResourceSet rs = new ResourceSetImpl();
					Resource resource = rs.getResource(uri, true);
					
					/* Searching for errors inside the document? */
					/* 1) Error with the syntax of the dsl */
					if (resource.getErrors().size() > 0) {	return false; } 
					if (resource.getContents().size() == 0) { return false;	}
					/* 2) Custom validation rule errors */
					Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
					if (diagnostic.getSeverity() == Diagnostic.ERROR) { 
						return false; 
					}
				
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This handler processes the xtext file and
	 * starts the mapper
	 */
	@Execute
	public Object execute(MApplication application, EModelService service, IProgressMonitor monitor) {
				
		MPart editorPart = Helpers.getActiveEditor(application, service);
		if (editorPart == null) return null;
		
		if (editorPart.getObject() instanceof CompatibilityEditor) {
			CompatibilityEditor compEditor = (CompatibilityEditor) editorPart.getObject();
			if (compEditor.getEditor() instanceof MultiPageEditor) {
				MultiPageEditor editor = (MultiPageEditor) compEditor.getEditor();
				editor.resetView();
				editor.doSave(monitor);
				IEditorInput input = editor.getEditorInput();
				if (input instanceof IFileEditorInput) {
					IPath path = ((IFileEditorInput)input).getFile().getLocation();

					URI uri = URI.createFileURI(path.toOSString());
					ResourceSet rs = new ResourceSetImpl();
					Resource resource = rs.getResource(uri, true);
					
					/* Searching for errors inside the document? */
					/* 1) Error with the syntax of the dsl */
					if (resource.getErrors().size() > 0) {	
						ConsoleCommands.writeLineToConsole("Input contains errors - it will not be processed."); 
						return null; 
					}
					
					if (resource.getContents().size() == 0) { 
						ConsoleCommands.writeLineToConsole("Input is empty? It will not be processed."); 
						return null;
					}
					/* 2) Custom validation rule errors */
					Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
					if (diagnostic.getSeverity() == Diagnostic.ERROR) {
						ConsoleCommands.writeLineToConsole("There are still some errors in the input. It will not be processed."); 
						return null;
					}
					
					
					/* Create a new model for the input */
					AssistModel inputModel = (AssistModel) resource.getContents().get(0);
					
					/* Fix the model */
					// Threads are not part of the input - only implicitely; thus we have to create them afterwards
					PostProcessor.createMissingThreads(inputModel);
					// Each board is a "local network" to allow "communicating" applications to be mapped to the same board
					// -> but local networks are not part of the input so they have to be created afterwards
					PostProcessor.createMissingBoardLocalNetworks(inputModel);
					
					if (editor instanceof MultiPageEditor) {
						
						/* Open the dialog to choose between simple and advanced mode for finding solutions */
						SimpleOrAdvancedModeDialog soamd = new SimpleOrAdvancedModeDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
						
						if (soamd.open() == org.eclipse.jface.window.Window.OK) {
							// User hat OK geklickt
							/* Create a new background Job for finding all solutions */
							GuiSolverJob findSolutionsJob = new GuiSolverJob("Find all mappings", inputModel, (MultiPageEditor)editor);
							findSolutionsJob.setUser(true);
							switch (soamd.getMode()) {
							case CONSECUTIVE:
								findSolutionsJob.setKindOfSolutions(SearchType.CONSECUTIVE);
								findSolutionsJob.setMaxSolutions(soamd.getNumberOfSolutions());
								findSolutionsJob.setMaxTimeOfCalculationInmsec(soamd.getSearchTime());
								findSolutionsJob.setRetrieveExplanation(soamd.getRetrieveExplanation());
								break;
							}

							findSolutionsJob.schedule();
						} 						
					} 
				}
			}
		}
	return null;	
	}
}
