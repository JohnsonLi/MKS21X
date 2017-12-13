import javax.swing.*;
import java.awt.*;

public class TemperatureWindow extends JFrame implements ActionListenser{
    
    public TemperatureWindow(){
     this.setTitle("Temperature Converter");
     this.setSize(600,300);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  

         
    }   

        
}
