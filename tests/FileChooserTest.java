import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;

public class FileChooserTest extends JFrame implements ActionListener{

    private Container container;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem openFile, saveFile;
    private JPanel jPanel;


    public FileChooserTest(){
        setTitle("FileChooserTest");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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


        jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(1200,720));
        jPanel.setBackground(Color.BLACK);

        container.setLayout(new FlowLayout());

        container.add(jMenuBar);
        container.add(jPanel);
        jMenuBar.add(jMenu);
        jMenu.add(openFile);
        jMenu.add(saveFile);

        pack();
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
        hi.setVisible(true);
    }

}
