package MessungBetriebsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddHDD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTest;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AddHDD(PC pc) {
		setBounds(100, 100, 180, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtTest = new JTextField();
		txtTest.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {

			}

			@Override
			public void inputMethodTextChanged(InputMethodEvent event) {
				// TODO Auto-generated method stub
				pc.setHddname(txtTest.getText());
			}

		});
		txtTest.setText("Hersteller");
		txtTest.setBounds(10, 40, 77, 20);
		contentPanel.add(txtTest);
		txtTest.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(100)));
		spinner.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				pc.setHddkapa((int) spinner.getValue());
			}
		});
		spinner.setBounds(10, 89, 45, 20);
		contentPanel.add(spinner);

		JLabel lblHersteller = new JLabel("Hersteller:");
		lblHersteller.setBounds(10, 15, 77, 14);
		contentPanel.add(lblHersteller);

		JLabel lblSpeicherKapazitt = new JLabel("Speicher Kapazit\u00E4t");
		lblSpeicherKapazitt.setBounds(10, 71, 122, 14);
		contentPanel.add(lblSpeicherKapazitt);
		
		JLabel lblGb = new JLabel("GB");
		lblGb.setBounds(65, 92, 22, 14);
		contentPanel.add(lblGb);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						pc.setHddkapa((int) spinner.getValue());
						pc.setHddname(txtTest.getText());
						pc.addhdd();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		try {

			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
