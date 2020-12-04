/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import frames.messageBox;
import frames.tablaM;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kuro
 */
public class textConverter {

    public JTextField fileNameBox;
    public JScrollPane jScrollPane6;
    public JTable tablecontent6;
    public JTextArea textArea;
    public JProgressBar jProgressBar1;

    public textConverter() {

    }

    public textConverter(JTextField fileNameBox, JScrollPane jScrollPane6, JTable tablecontent6, JTextArea textArea, JProgressBar jProgressBar1) {
        this.fileNameBox = fileNameBox;
        this.jScrollPane6 = jScrollPane6;
        this.tablecontent6 = tablecontent6;
        this.textArea = textArea;
        this.jProgressBar1 = jProgressBar1;
    }

    public void messageText(String msg) {
        messageBox messageBox = new messageBox(msg);
        messageBox.setVisible(true);
    }

    public void progressBar(String message) {
        int progress = 0;
        Random random = new Random();
        while (progress < 100) {
            //Sleep for up to one second.
            try {
                Thread.sleep(random.nextInt(14));
            } catch (InterruptedException ignore) {
            }
            progress += 1;
            jProgressBar1.setValue(progress);
            jProgressBar1.setString(progress + "%");
            Rectangle progressRect = jProgressBar1.getBounds();//important line 
            progressRect.x = 0;
            progressRect.y = 0;
            jProgressBar1.paintImmediately(progressRect);//important line 
        }
        if (progress == 100) {
            jProgressBar1.setString(message);
        }

    }

    public void saveChooserFile() {
        if (textArea.getText().equals("")) {
            messageText("TEXT AREA EMPTY");

        } else {
            if (fileNameBox.getText().equals("")) {
                messageText("INVALID URL");
            } else {
                saveTextToHex(fileNameBox.getText(), (new StringBuffer(textArea.getText())));

                messageText("Text saved succerfully");

            }

        }
    }

    public void chooserFilePasswordTable() {
        if (tablecontent6.getSelectedRowCount() >= 1) {
            String selectRow = String.valueOf(tablecontent6.getValueAt(tablecontent6.getSelectedRow(), 3));
            if (jScrollPane6.isVisible() == true && selectRow.endsWith("aoec")) {

                loadHexToString("txt/" + selectRow);
                fileNameBox.setText("txt/" + selectRow);
            } else {
                messageText("Select AOEC file type");
            }
        } else {
            messageText("Select AOEC file type");
        }

    }

    public void chooserFile() {
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("AOEC Encryption", "AOEC");
        JFileChooser chooser = new JFileChooser("txt");
        chooser.addChoosableFileFilter(filter1);
        chooser.setFileFilter(filter1);
        chooser.showOpenDialog(null);

        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        fileNameBox.setText(filename);
        if (filename.endsWith("aoec")) {
            loadHexToString(filename);
        } else {

            messageText("Select AOEC file type");
            fileNameBox.setText("");
        }
    }

    public void loadHexToString(String filePath) {
        progressBar("Decrypted Complete!");
        String gg = "";
        File file = new File(filePath);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            Object[] lines = br.lines().toArray();
            for (int i = 0; i < lines.length; i++) {
                gg = gg + lines[i].toString();
            }

            StringBuffer gg0 = new StringBuffer(gg);
            gg0.reverse().toString();
            String gg2 = convertHexToString(gg0.toString());

            String bk;
            String bk2;
            if (gg2.length() % 2 == 0) {
                bk = gg2.substring(0, gg2.length() / 2);
                bk2 = gg2.substring(gg2.length() / 2, gg2.length());
                textArea.setText(convertHexToString(bk2 + bk));
            } else {
                bk = gg2.substring(0, gg2.length() / 2);
                bk2 = gg2.substring((gg2.length() / 2) - 1, gg2.length());
                textArea.setText(convertHexToString(bk2 + bk));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    public void saveTextToHex(String filePath, StringBuffer TXT) {
        progressBar("Encrypted Complete!");
        File file = new File(filePath);
        try {

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            //bw.newLine();
            char[] chars = (new StringBuffer(TXT).toString()).toCharArray();
            StringBuffer hex = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                hex.append(Integer.toHexString((int) chars[i]));
            }
            String bk = hex.substring(0, hex.length() / 2);
            String bk2 = hex.substring(hex.length() / 2, hex.length());
            StringBuffer hex2 = new StringBuffer(bk2 + bk);

            char[] chars2 = (hex2.toString().toCharArray());
            StringBuffer hex3 = new StringBuffer();
            for (int i = 0; i < chars2.length; i++) {
                hex3.append(Integer.toHexString((int) chars2[i]));
            }
            bw.write(hex3.reverse().toString());

            bw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
