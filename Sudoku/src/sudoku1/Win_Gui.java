package sudoku1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_Gui extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public Win_Gui() {
		setBounds(100, 100, 279, 164);
		getContentPane().setLayout(null);
		contentPanel.setBounds(26, 11, 255, 72);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblHerzlichenGlckwunsch = new JLabel("Herzlichen Gl\u00FCckwunsch!!!");
		lblHerzlichenGlckwunsch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHerzlichenGlckwunsch.setBounds(0, 11, 253, 50);
		contentPanel.add(lblHerzlichenGlckwunsch);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 92, 255, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
