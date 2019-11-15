package FrimenSoftware;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import würfel_Leiter.TestKlass;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private register frame = this;
	
	public register(Login dialog) {
		setBounds(100, 100, 192, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			passwordField = new JPasswordField();
			passwordField.setText("");
			passwordField.setBounds(27, 70, 105, 20);
			contentPanel.add(passwordField);
		}
		{
			textField = new JTextField();
			textField.setBounds(27, 25, 105, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNameIhrerFirma = new JLabel("Name Ihrer Firma:");
			lblNameIhrerFirma.setBounds(27, 11, 88, 14);
			contentPanel.add(lblNameIhrerFirma);
		}
		{
			JLabel lblPasswort = new JLabel("Passwort:");
			lblPasswort.setBounds(27, 56, 75, 14);
			contentPanel.add(lblPasswort);
		}
		{
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(27, 114, 105, 20);
			contentPanel.add(passwordField_1);
		}
		{
			JLabel lblBesttigen = new JLabel("Best\u00E4tigen:");
			lblBesttigen.setBounds(27, 101, 75, 14);
			contentPanel.add(lblBesttigen);
		}
		{
			JButton btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialog.setVisible(true);
					frame.dispose();
				}
			});
			btnLogin.setBounds(27, 159, 105, 23);
			contentPanel.add(btnLogin);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(isPassEqual() == true) {
							speicher s = new speicher();
							s.registrieren(textField.getText(), s.encryptThisString(new String(passwordField.getPassword())));
							firma f = new firma(textField.getText());
							s.Speichern(f);
							dialog.setVisible(true);
							frame.dispose();
						}
						
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
						dialog.setVisible(true);
						frame.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public boolean isPassEqual() {
		if(passwordField.getPassword()!= null&& passwordField_1.getPassword()!= null) {
			
		if (new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
			return true;
		}
		}
		return false;
	}
}
