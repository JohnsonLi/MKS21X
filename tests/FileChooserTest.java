import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileChooserTest extends JFrame implements ActionListener{

    private Container container;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem openFile, saveFile;



    public FileChooserTest(){
        this.setTitle("FileChooserTest");
        this.setSize(500,300);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = this.getContentPane();
        jMenuBar = new JMenuBar();
        jMenu = new JMenu();
        openFile = new JMenuItem("open");
        saveFile = new JMenuItem("save");

        jMenu.setText("File");
        openFile.setText("Open File");
        saveFile.setText("Save File");
        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                openFileChooser(e);
            }
        });
        saveFile.addActionListener(this);

        container.setLayout(new FlowLayout());

        container.add(jMenuBar);
        jMenuBar.add(jMenu);
        jMenu.add(openFile);
        jMenu.add(saveFile);


    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == saveFile){
            JFileChooser saveFile = new JFileChooser();
            saveFile.showSaveDialog(null);
        }
    }

    private void openFileChooser(ActionEvent e){
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);
    }

    public static void main(String[] args) {
        FileChooserTest hi = new FileChooserTest();
        try {
     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

   } catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
        hi.setVisible(true);
    }

}
