package MessungBetriebsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JCheckBoxMenuItem;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PCGUI {
	private JFrame frame;
	JLabel lblNewLabel_1;
	private BS bs = new BS("Windows", 1, 0, new Prozess("Java", false, true, 3), "Intenso", 1000.0);
	private List<JLabel> panel = new ArrayList<JLabel>();
	private List<JLabel> pro = new ArrayList<JLabel>();
	private PC pc = new PC(bs, this);
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PCGUI window = new PCGUI();
					window.getFrame().setVisible(true);
					window.addLabel();
					window.addPro();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */

	public PCGUI() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 827, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("HDDs:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 40, 46, 14);
		getFrame().getContentPane().add(lblNewLabel);
		panel.add(lblNewLabel);

		JLabel lblGesamtSpeicherplatz = new JLabel("Gesamt Speicherplatz:");
		lblGesamtSpeicherplatz.setBounds(10, 5, 141, 14);
		frame.getContentPane().add(lblGesamtSpeicherplatz);
		
		JLabel lblNewLabel_2 = new JLabel("Prozesse:");
		lblNewLabel_2.setBounds(390, 40, 61, 14);
		frame.getContentPane().add(lblNewLabel_2);
		pro.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(161, 5, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblGb = new JLabel("GB");
		lblGb.setBounds(204, 5, 46, 14);
		frame.getContentPane().add(lblGb);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 55, 352, 29);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(4, 55, 34, 174);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(4, 228, 352, 55);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(353, 55, 46, 174);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(378, 228, 352, 29);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(378, 55, 352, 14);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(729, 55, 82, 174);
		frame.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(378, 55, 141, 174);
		frame.getContentPane().add(separator_7);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Add New");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAddHdd = new JMenuItem("Add HDD");
		mntmAddHdd.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				AddHDD addhdd = new AddHDD(pc);
			}
		});
		mnNewMenu.add(mntmAddHdd);
		
		JMenuItem mntmAddProzess = new JMenuItem("Add Prozess");
		mntmAddProzess.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				AddProzess addpro = new AddProzess(pc);
			}
		});
		mnNewMenu.add(mntmAddProzess);
		
		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);
		
		JMenu mnDeleteTesrt = new JMenu("Delete HDD");
		mnDelete.add(mnDeleteTesrt);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				char c = textField.getText().charAt(0);
				bs.entferneHDD(c);
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
		
		textField = new JTextField();
		mnDeleteTesrt.add(textField);
		textField.setColumns(10);
		mnDeleteTesrt.add(mntmDelete);
		
		JMenuItem mntmDeleteProzess = new JMenuItem("Delete Prozess");
		mntmDeleteProzess.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				bs.entfernen();
			}
		});
		mnDelete.add(mntmDeleteProzess);
		//list.
	}

	public void addLabel() {

		JLabel jl = new JLabel("");
		panel.add(jl);
		JLabel lastobject;

		lastobject = panel.get(panel.size() - 2);
		jl.setText(bs.toStringHDDs(panel.size() - 2));
		jl.setBounds(10, lastobject.getY() + lastobject.getHeight() + 5, 400, 14);
		getFrame().getContentPane().add(jl);
		panel.set(panel.size()-2, jl);
		
		SwingUtilities.updateComponentTreeUI(frame);
		
		lblNewLabel_1.setText(Double.toString(bs.brerechneGesamtkazitaet()));
		
		
	}
	public void addPro() {
		JLabel jl = new JLabel("");
		pro.add(jl);
		JLabel lastobject;

		lastobject = pro.get(pro.size() - 2);
		jl.setText(bs.toStringProzesse(pro.size() - 2));
		jl.setBounds(390, lastobject.getY() + lastobject.getHeight() + 5, 400, 14);
		getFrame().getContentPane().add(jl);
		pro.set(pro.size()-2, jl);
		
		SwingUtilities.updateComponentTreeUI(frame);
		
		lblNewLabel_1.setText(Double.toString(bs.brerechneGesamtkazitaet()));
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setResizable(false);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
