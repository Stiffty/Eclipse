package koordinatenSys3D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        Main m = new Main();
    }

    public Main() throws HeadlessException {
        JPanel contentPane = new JPanel();
        Draw draw = new Draw();

        setBounds(40,40,400,400);
        setTitle("3D");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        contentPane.add(new Button("HII".repeat(3)));
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));


        setContentPane(contentPane);

        getContentPane().add(draw);

        new Thread(()->{
         while (true){
             draw.repaint();
         }
        }).start();
    }

}
