import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

import javax.swing.JToggleButton;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;

public class HelloWorld extends Composite {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public HelloWorld(Composite parent, int style) {
		super(parent, SWT.BORDER | SWT.NO_BACKGROUND);
		
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(160, 72, 55, 15);
		lblNewLabel.setText("New Label");
		
		Button btnHelp = new Button(this, SWT.NONE);
		btnHelp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNewLabel.setText("Label");
			}
		});
		btnHelp.setBounds(160, 164, 75, 25);
		btnHelp.setText("Help");
		
		Button btnNewButton = formToolkit.createButton(this, "New Button", SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNewLabel.setText("Label");
			}
		});
		btnNewButton.setBounds(193, 243, 75, 25);
		
		Form frmNewForm = formToolkit.createForm(this);
		frmNewForm.setBounds(88, 268, 0, 0);
		formToolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("New Form");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
