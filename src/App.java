import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.io.PrintWriter;
public class App {
    // JFrame
    static JFrame jFrame;

    // text area
    static JTextArea jTextArea;

    // save button
    static JButton jButtonSave;
    static String pathname = "bin//tmp//sample.txt";
    static String bacaFile(){
        String isiFile = "";
        try {
            // ganti "/tmp/sample3.data" dengan path file teks yang akan dibaca
            File myObj = new File(pathname);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                isiFile = isiFile + myReader.nextLine();
                // System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //System.out.println(isiFile);
        return isiFile;
    }    
    public static void main(String[] args) {
        // create a new frame to store text field and button
        jFrame = new JFrame("File Reader");

        // create a text area, specifying the rows and columns
        jTextArea = new JTextArea("test");

        

        Font font = new Font("Verdana", Font.BOLD, 20);
        jTextArea.setFont(font);

        jTextArea.setText(bacaFile());
        jTextArea.setBounds(0,0, 400,400);
        
        // create a button, for saving
        jButtonSave = new JButton("Save");
        jButtonSave.setBounds(5,400,80,30);  
        
        jButtonSave.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                        File path = new File(pathname);
                            try (FileWriter fileWriter = new FileWriter(path)) {
                                PrintWriter printWriter = new PrintWriter(fileWriter);
                                printWriter.print(jTextArea.getText());
                                printWriter.close();
                                JOptionPane.showMessageDialog(null, "File Telah disimpan");
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        
                    }  
                });  
        // jFrame
        jFrame.add(jTextArea);
        jFrame.add(jButtonSave);
        // set the size of frame
        jFrame.setSize(400, 500);
        jFrame.setLayout(null);
        jFrame.setVisible(true); 
        

        
    }
}
