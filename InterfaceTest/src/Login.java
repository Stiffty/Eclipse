import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {
 
private JButton button;

 public Login()
  {
  super("Login . . .");

  JPanel pane1 = new JPanel();

  button = new JButton(new ImageIcon("x1.gif"));
  button.setPressedIcon(new ImageIcon("x2.gif"));
  button.setRolloverIcon(new ImageIcon("x3.gif"));
  button.setDisabledIcon(new ImageIcon("x1.gif"));
  button.setFocusPainted(false);
  button.setBorderPainted(false);
  button.setContentAreaFilled(false);
  button.setMargin(new Insets(0,0,0,0));

  pane1.add(button);

  setContentPane(pane1);

  Dimension sd  = Toolkit.getDefaultToolkit().getScreenSize();

  setLocation(sd.width / 2 - 200 / 2,
  sd.height / 2 - 130 / 2);

  pane1.setBackground(Color.black);
  setResizable(false);
  setSize(200,130);    
  show();
  }


// Main method

  public static void main( String args[] )
   {
      Login app = new Login();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }
} 