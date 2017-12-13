import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame /*implements ActionListener*/{
    private Container pane;    

    private JButton b;
    private JTextField t;
    private JCheckBox F2C;
    private JCheckBox C2F;    

    public TemperatureWindow(){
        this.setTitle("Temperature Converter");
        this.setSize(400,200);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());  
 
        b = new JButton("CONVERT");
        t = new JTextField(10);
        F2C = new JCheckBox("F to C");
        C2F = new JCheckBox("C to F");
            
        pane.add(b);
        pane.add(t);
        pane.add(F2C);
        pane.add(C2F);
       
    }  

    public static double FtoC (double farenheit) {
	    return (farenheit - 32) * 5 / 9;
    }
   
    public static double CtoF (double celcius) {
    	return celcius * 9 / 5 + 32;
    }

    public void 

    public static void main(String[] args){
        TemperatureWindow hi = new TemperatureWindow();
        hi.setVisible(true);
    }
        
}








