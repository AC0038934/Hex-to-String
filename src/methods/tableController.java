/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import model.file;
import frames.messageBox;
import frames.tablaM;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kuro
 */
public class tableController extends textConverter {

    private ArrayList<file> lista = new ArrayList<file>();

    public tableController() {
    }


    public void messageText(String msg) {
        messageBox messageBox = new messageBox(msg);
        messageBox.setVisible(true);
    }

    public void saveTable(JTable JTable, String filePath) {
        File file = new File(filePath);
        try {

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < JTable.getRowCount(); i++) {
                for (int j = 0; j < JTable.getColumnCount(); j++) {
                    bw.write(JTable.getValueAt(i, j).toString() + "-");
                }
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadTable(JTable JTable, String filePath) {
        File file = new File(filePath);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            Object[] lines = br.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split("-");
                model.addRow(row);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(tablaM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTable(JTable JTable) {
        Date date = new Date();
       DefaultTableModel model;
       Object contenido[] = new Object[99];
        model = (DefaultTableModel) JTable.getModel();
        for (int i = 0; i < this.lista.size(); i++) {
            contenido[0] = this.lista.get(i).getName();
            contenido[1] = new SimpleDateFormat("yyyy.MM.dd").format(date);
            contenido[2] = this.lista.get(i).getType();
            contenido[3] = this.lista.get(i).getState();

            model.addRow(contenido);
        }
        JTable.setModel(model);

    }

    public void saveAllTable(JTable tablecontent6) {

        saveTable(tablecontent6, "tb/" + "tb6.uwu");
    }

    public void loadAllTable(JTable tablecontent6) {

        if (System.getProperties().getProperty("os.name").equals("Windows 10") || System.getProperties().getProperty("os.name").equals("Windows 7")) {

            loadTable(tablecontent6, "tb" + "\\tb6.uwu\\");
        } else if (System.getProperties().getProperty("os.name").equals("Linux")) {

            loadTable(tablecontent6, "tb" + "//tb6.uwu//");
        }

    }


    public void createFile(JTable tablecontent6, JTextField nameBox, JTextField passwordBox, JScrollPane jScrollPane6, JLabel jLabel2, JProgressBar jProgressBar1, JTextField fileNameBox, JTextArea textArea) {
        String waiting = "Waiting";
        String type = "";

        if (nameBox.getText().isEmpty() || nameBox.getText().equals("Filename...")) {
            messageText("Filename is empty");
        } else {

            type = "AOEC";
            String dir = nameBox.getText() + ".aoec";
            String pass = passwordBox.getText();
            this.lista.add(new file(nameBox.getText(), type, dir));
            addTable(tablecontent6);
            textConverter textConverter = new textConverter();
            
            textConverter.saveTextToHex("txt/" + dir, (new StringBuffer(pass)), jProgressBar1);
            messageText("Entry added succerfully");
        }

        //getLista().clear();
        //filter("");
    }

}
