package ch.hilbri.assist.application.parts;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;

/**
 * Dialog which will show up after entering the "Help->About" menu.
 *
 */
public class AboutDialog extends TitleAreaDialog {

	public static String versionNumber = "1.0";
	
	@Inject
	public AboutDialog(
		@Named(IServiceConstants.ACTIVE_SHELL) Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Architecture Synthesis for Safety-Critical Systems");
		setTitle("About ASSIST");

		Composite area = (Composite) super.createDialogArea(parent);
		
	
		Composite container = new Composite(area, SWT.NONE);
	    container.setLayout(null);
	    GridData gd_container = new GridData(SWT.FILL, SWT.FILL, true, true);
	    gd_container.heightHint = 306;
	    container.setLayoutData(gd_container);
	    
	    Label lblNewLabel = new Label(container, SWT.NONE);
	    lblNewLabel.setImage(ResourceManager.getPluginImage("ch.hilbri.assist.application", "icons/about.jpg"));
	    lblNewLabel.setBounds(0, -2, 447, 235);
	    
	    Label lblVersion = new Label(container, SWT.NONE);
	    lblVersion.setBounds(10, 266, 55, 15);
	    lblVersion.setText("Version:");
	    
	    Label lblHomepage = new Label(container, SWT.NONE);
	    lblHomepage.setBounds(10, 287, 72, 15);
	    lblHomepage.setText("Homepage:");
	    
	    Label lblLicense = new Label(container, SWT.NONE);
	    lblLicense.setBounds(10, 308, 55, 15);
	    lblLicense.setText("License:");
	    
	    Label label = new Label(container, SWT.NONE);
	    label.setBounds(100, 266, 55, 15);
	    label.setText(Platform.getBundle("ch.hilbri.assist.application").getHeaders().get("Bundle-Version"));
	    
	    Label lblHttpassisthilbrich = new Label(container, SWT.NONE);
	    lblHttpassisthilbrich.setBounds(100, 287, 147, 15);
	    lblHttpassisthilbrich.setText("http://assist.hilbri.ch");
	    
	    Label lblNewLabel_1 = new Label(container, SWT.NONE);
	    lblNewLabel_1.setBounds(100, 308, 211, 15);
	    lblNewLabel_1.setText("GNU General Public License (GPLv3)");
	    
	    Label lblMainAuthor = new Label(container, SWT.NONE);
	    lblMainAuthor.setBounds(10, 245, 72, 15);
	    lblMainAuthor.setText("Main Author:");
	    
	    Label lblRobertHilbrich = new Label(container, SWT.NONE);
	    lblRobertHilbrich.setBounds(100, 245, 135, 15);
	    lblRobertHilbrich.setText("Robert Hilbrich");
	    
		return area;
	}  
	
	
	
	@Override
	protected Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// create a layout with spacing and margins appropriate for the font
		// size.
		GridLayout layout = new GridLayout();
		layout.numColumns = 0; // this is incremented by createButton
		layout.makeColumnsEqualWidth = true;
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		composite.setLayout(layout);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_END
				| GridData.VERTICAL_ALIGN_CENTER);
		composite.setLayoutData(data);
		composite.setFont(parent.getFont());
		
		createButton(composite, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		
		return composite;
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
	  super.configureShell(newShell);
	  newShell.setText("About ASSIST");
	}

	
	
	@Override
	protected Point getInitialSize() {
	  return new Point(454, 480);
	}

}
