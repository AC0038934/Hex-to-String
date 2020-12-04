/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import gui.messageBox;
import gui.tablaM;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kuro
 */
public class extraTools {

    public extraTools() {
    }
    
    public void clipboardFunction(JTextArea textArea) {
        if (textArea.getText().isEmpty()) {
        
        messageBox messageBox = new messageBox("Text area is empty");
        messageBox.setVisible(true);

        } else {
            String ctc = textArea.getText().toString();
            StringSelection stringSelection = new StringSelection(ctc);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            
        messageBox messageBox = new messageBox("Text copied succerfully");
        messageBox.setVisible(true);


        }

    }
       public String generatePassword(String option) {
            //System.out.println(option);
        String password = "";
        String key = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefgjijklmnopqwxyz@!#=1234567890";
        if(option.equals("Full Comb")){
            key = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefgjijklmnopqwxyz@!#=1234567890";
        }else if(option.equals("Only Number")){
            key = "1234567890";
        }else if(option.equals("Number + Letters")){
            key = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefgjijklmnopqwxyz1234567890";
        }
        
        Random rn = new Random();
        for (int i = 0; i < rn.nextInt((36 + 1) - 29) + 29; i++) {
            char keyreturn = key.charAt((int) (Math.random() * key.length()));
            password = password + String.valueOf(keyreturn);
        }
        return password;
        
    }

    public void TrueCrypt() {
        Runtime runTime = Runtime.getRuntime();
        try {
            Process process = runTime.exec("C:\\Program Files\\TrueCrypt\\TrueCrypt.exe");
        } catch (IOException ex) {
            Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveScreenshot() {
        String SS = JOptionPane.showInputDialog(null, "Enter screenshot name");
        if (SS.equals("")) {

        } else {
            BufferedImage image = null;
            try {
                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            } catch (AWTException ex) {
                Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ImageIO.write(image, "png", new File(SS + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
