package tuermeVonHanoi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private JPanel mainPanel;
    private JButton brtrtrtButton;
    JPanel contentpane = new JPanel();

    private Draw draw = new Draw();

    public MainGUI() {


        setTitle("Test Hanoi");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Button b = new Button("TRest");
        b.setBounds(50, 50, 50, 50);

        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentpane.setLayout(new BorderLayout(0, 0));

        setContentPane(contentpane);
        getContentPane().add(b);
        getContentPane().add(draw);



        new Thread(() -> {
            while (true) {
                draw.repaint();

            }
        }).start();
    }
}
