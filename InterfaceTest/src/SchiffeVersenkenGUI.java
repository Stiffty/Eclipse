import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
// Damit Objekte der Klasse BeispielListener
// zum ActionListener werden kann, muss das Interface
// ActionListener implementiert werden
public class SchiffeVersenkenGUI extends JFrame implements ActionListener
{
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JLabel label;
    JPanel panel;
 
    public SchiffeVersenkenGUI(){
        this.setTitle("ActionListener Beispiel");
        this.setSize(400, 200);
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        label = new JLabel();
       
        //Drei Buttons werden erstellt
        button1 = new JButton("Busch 1");
        button2 = new JButton ("Busch 2");
        button3 = new JButton ("Busch 3");
        button4 = new JButton ("Busch 4 ");
 
        button1.setBackground(Color.GREEN);
        button2.setBackground(Color.GREEN);
        button3.setBackground(Color.GREEN);
        button4.setBackground(Color.GREEN);
        
        
        //Buttons werden dem Listener zugeordnet
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
 
        //Buttons werden dem JPanel hinzugefügt
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
 
        //JLabel wird dem Panel hinzugefügt
        panel.add(label);
        this.add(panel);
    }
 
    public static void main(String[] args)
    {
        // Ein neues Objekt der Klasse BeispielListener wird erzeugt
        // und sichtbar gemacht
        BeispielListener bl = new BeispielListener();
        bl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bl.setVisible(true);
      
    }
 
    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
    	int [] vogel = {0, 0, 1, 0};
    	button3.setBackground(Color.RED);
        if(ae.getSource() == this.button1){
        	if (vogel[0] == 1) {
            label.setText(("Vogel getroffen "));
            button3.setBackground(Color.RED);
        	}
        	else {
        		 label.setText(("Vogel verfehlt "));
        	}
        }
        else if(ae.getSource() == this.button2){
        	if (vogel[1] == 1) {
                label.setText(("Vogel getroffen "));
                button3.setBackground(Color.RED);
            	}
            	else {
            		 label.setText(("Vogel verfehlt "));
            	}
        }
        else if (ae.getSource() == this.button3){
        	if (vogel[2] == 1) {
                label.setText(("Vogel getroffen "));
                ((JButton)ae.getSource()).setBackground(Color.RED);
            	}
            	else {
            		 label.setText(("Vogel verfehlt "));
            	}
        }
        else if (ae.getSource() == this.button4) {
        	if (vogel[3] == 1) {
                label.setText(("Vogel getroffen "));
                button3.setBackground(Color.RED);
            	}
            	else {
            		 label.setText(("Vogel verfehlt "));
            	}
        }
    }
}