package MessungBetriebsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;

public class AddProzess extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtProzessName;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public AddProzess(PC pc) {
		setResizable(false);
		setBounds(100, 100, 183, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Prozess name:");
			lblNewLabel.setBounds(10, 11, 90, 14);
			contentPanel.add(lblNewLabel);
		}

		txtProzessName = new JTextField();
		txtProzessName.setText("Prozess name");
		txtProzessName.setBounds(10, 36, 86, 20);
		contentPanel.add(txtProzessName);
		txtProzessName.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spinner.setBounds(10, 92, 46, 20);
		contentPanel.add(spinner);

		JLabel lblNewLabel_1 = new JLabel("Priorit\u00E4t:");
		lblNewLabel_1.setBounds(10, 67, 60, 14);
		contentPanel.add(lblNewLabel_1);
		
		JCheckBox chckbxBereit = new JCheckBox("Bereit");
		chckbxBereit.setBounds(111, 119, 60, 23);
		contentPanel.add(chckbxBereit);
		
		JCheckBox chckbxLaufend = new JCheckBox("Laufend");
		chckbxLaufend.setBounds(6, 119, 90, 23);
		contentPanel.add(chckbxLaufend);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pc.setProname(txtProzessName.getText());
						pc.setPrio((int) spinner.getValue());
						pc.setL(chckbxLaufend.isSelected());
						pc.setB(chckbxBereit.isSelected());
						pc.addpro();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
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
