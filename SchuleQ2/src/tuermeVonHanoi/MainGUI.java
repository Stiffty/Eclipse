package tuermeVonHanoi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private JPanel mainPanel;
    private JButton brtrtrtButton;

    private Draw draw = new Draw();
    public MainGUI()  {


        setBounds(100,100,300,300);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.add(draw);

        new Thread(()->{
            mainPanel.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        brtrtrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
