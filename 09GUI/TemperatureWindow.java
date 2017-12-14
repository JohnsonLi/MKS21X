import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;    

    private JTextField t;
    private JButton F2C;
    private JButton C2F;    

    public TemperatureWindow(){
        this.setTitle("Temperature Converter");
        this.setSize(400,200);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());  
 
        t = new JTextField(10);
        t.addActionListener(this);
        F2C = new JButton("F to C");
        F2C.addActionListener(this);
        C2F = new JButton("C to F");
        C2F.addActionListener(this);
            
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

    public void actionPerformed(ActionEvent e){
        String event = e.getActionCommand();
        if (event.equals("F to C")){
            t.setText("" + FtoC(Double.parseDouble(t.getText())));
        }
        if (event.equals("C to F")){
            t.setText("" + CtoF(Double.parseDouble(t.getText())));
        }
        
    }

    public static void main(String[] args){
        TemperatureWindow hi = new TemperatureWindow();
        hi.setVisible(true);
    }
        
}








