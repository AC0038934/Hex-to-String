/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package build;

import gui.messageBox;
import gui.tablaM;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kuro
 */
public class tableController extends textConverter {

    public ArrayList<file> lista = new ArrayList();
//    public JTable tablecontent;
//    public JTable tablecontent3;
//    public JTable tablecontent4;
//    public JTable tablecontent5;
    public JTable tablecontent6;
    public JTable JTable;
    public DefaultTableModel model;
    public Object contenido[] = new Object[99];

    public JTextField nameBox;

    public JTextField passwordBox;

//    public JScrollPane jScrollPane1;
//    public JScrollPane jScrollPane3;
//    public JScrollPane jScrollPane4;
//    public JScrollPane jScrollPane5;
    public JScrollPane jScrollPane6;
    public JLabel jLabel2;

    public JProgressBar jProgressBar1;

    public tableController() {
    }

    public tableController(JTable tablecontent6) {
        this.tablecontent6 = tablecontent6;
    }
    
    

    public tableController(JTable tablecontent6, JTextField nameBox, JTextField passwordBox, JScrollPane jScrollPane6, JLabel jLabel2, JProgressBar jProgressBar1) {
        this.tablecontent6 = tablecontent6;
        this.nameBox = nameBox;
        this.passwordBox = passwordBox;
        this.jScrollPane6 = jScrollPane6;
        this.jLabel2 = jLabel2;
        this.jProgressBar1 = jProgressBar1;
    }
    
    

//    public tableController(JTable tablecontent, JTable tablecontent3, JTable tablecontent4, JTable tablecontent5, JTable tablecontent6, JTextField nameBox, JTextField passwordBox, JScrollPane jScrollPane1, JScrollPane jScrollPane3, JScrollPane jScrollPane4, JScrollPane jScrollPane5, JScrollPane jScrollPane6, JLabel jLabel2, JProgressBar jProgressBar1) {
//        this.tablecontent = tablecontent;
//        this.tablecontent3 = tablecontent3;
//        this.tablecontent4 = tablecontent4;
//        this.tablecontent5 = tablecontent5;
//        this.tablecontent6 = tablecontent6;
//        this.nameBox = nameBox;
//        this.passwordBox = passwordBox;
//        this.jScrollPane1 = jScrollPane1;
//        this.jScrollPane3 = jScrollPane3;
//        this.jScrollPane4 = jScrollPane4;
//        this.jScrollPane5 = jScrollPane5;
//        this.jScrollPane6 = jScrollPane6;
//        this.jLabel2 = jLabel2;
//        this.jProgressBar1 = jProgressBar1;
//    }
//
//    public tableController(JTable tablecontent, JTable tablecontent3, JTable tablecontent4, JTable tablecontent5, JTable tablecontent6) {
//        this.tablecontent = tablecontent;
//        this.tablecontent3 = tablecontent3;
//        this.tablecontent4 = tablecontent4;
//        this.tablecontent5 = tablecontent5;
//        this.tablecontent6 = tablecontent6;
//    }
//
//    public tableController(JScrollPane jScrollPane1, JScrollPane jScrollPane3, JScrollPane jScrollPane4, JScrollPane jScrollPane5, JScrollPane jScrollPane6, JLabel jLabel2) {
//        this.jScrollPane1 = jScrollPane1;
//        this.jScrollPane3 = jScrollPane3;
//        this.jScrollPane4 = jScrollPane4;
//        this.jScrollPane5 = jScrollPane5;
//        this.jScrollPane6 = jScrollPane6;
//        this.jLabel2 = jLabel2;
//    }
//
//    public tableController(JTable tablecontent, JTable tablecontent4, JTable tablecontent5, JTable tablecontent6, DefaultTableModel model) {
//        this.tablecontent = tablecontent;
//        this.tablecontent4 = tablecontent4;
//        this.tablecontent5 = tablecontent5;
//        this.tablecontent6 = tablecontent6;
//        this.model = model;
//    }
//
//    public tableController(JTable tablecontent, JTable tablecontent3, JTable tablecontent4, JTable tablecontent5, JTable tablecontent6, JTextField nameBox, JCheckBox animeCheck, JCheckBox movieCheck, JCheckBox serieCheck, JCheckBox gameCheck, JCheckBox txtCheck, JTextField passwordBox, JScrollPane jScrollPane1, JScrollPane jScrollPane3, JScrollPane jScrollPane4, JScrollPane jScrollPane5, JScrollPane jScrollPane6, JLabel jLabel2, JProgressBar jProgressBar1) {
//        this.tablecontent = tablecontent;
//        this.tablecontent3 = tablecontent3;
//        this.tablecontent4 = tablecontent4;
//        this.tablecontent5 = tablecontent5;
//        this.tablecontent6 = tablecontent6;
//        this.nameBox = nameBox;
//        this.passwordBox = passwordBox;
//        this.jScrollPane1 = jScrollPane1;
//        this.jScrollPane3 = jScrollPane3;
//        this.jScrollPane4 = jScrollPane4;
//        this.jScrollPane5 = jScrollPane5;
//        this.jScrollPane6 = jScrollPane6;
//        this.jLabel2 = jLabel2;
//        this.jProgressBar1 = jProgressBar1;
//    }

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
        model = (DefaultTableModel) JTable.getModel();
        for (int i = 0; i < lista.size(); i++) {
            contenido[0] = lista.get(i).getName();
            contenido[1] = new SimpleDateFormat("yyyy.MM.dd").format(date);
            contenido[2] = lista.get(i).getType();
            contenido[3] = lista.get(i).getState();

            model.addRow(contenido);
        }
        JTable.setModel(model);

    }

    public void saveAllTable() {

//        saveTable(tablecontent, "tb/" + "tb1.uwu");
//        saveTable(tablecontent3, "tb/" + "tb3.uwu");
//        saveTable(tablecontent4, "tb/" + "tb4.uwu");
//        saveTable(tablecontent5, "tb/" + "tb5.uwu");
        saveTable(tablecontent6, "tb/" + "tb6.uwu");
    }

    public void loadAllTable() {

        if (System.getProperties().getProperty("os.name").equals("Windows 10") || System.getProperties().getProperty("os.name").equals("Windows 7")) {
//            loadTable(tablecontent, "tb" + "\\tb1.uwu\\");
//            loadTable(tablecontent3, "tb" + "\\tb3.uwu\\");
//            loadTable(tablecontent4, "tb" + "\\tb4.uwu\\");
//            loadTable(tablecontent5, "tb" + "\\tb5.uwu\\");
            loadTable(tablecontent6, "tb" + "\\tb6.uwu\\");
        } else if (System.getProperties().getProperty("os.name").equals("Linux")) {
//           loadTable(tablecontent, "tb" + "//tb1.uwu//");
//            loadTable(tablecontent3, "tb" + "//tb3.uwu//");
//            loadTable(tablecontent4, "tb" + "//tb4.uwu//");
//            loadTable(tablecontent5, "tb" + "//tb5.uwu//");
            loadTable(tablecontent6, "tb" + "//tb6.uwu//");
        }

    }

//    public void tableRotation() {
//
//        if (jScrollPane1.isVisible() == true) {
//            jScrollPane1.setVisible(false);
//            jScrollPane3.setVisible(true);
//            jLabel2.setText("Movie");
//
//        } else if (jScrollPane3.isVisible() == true) {
//            jScrollPane3.setVisible(false);
//            jScrollPane4.setVisible(true);
//            jLabel2.setText("Serie");
//
//        } else if (jScrollPane4.isVisible() == true) {
//            jScrollPane4.setVisible(false);
//            jScrollPane5.setVisible(true);
//            jLabel2.setText("Game");
//
//        } else if (jScrollPane5.isVisible() == true) {
//            jScrollPane5.setVisible(false);
//            jScrollPane6.setVisible(true);
//            jLabel2.setText("Password List");
//        } else if (jScrollPane6.isVisible() == true) {
//            jScrollPane6.setVisible(false);
//            jScrollPane1.setVisible(true);
//            jLabel2.setText("Anime");
//        }
//    }

    public void createFile() {
        String waiting = "Waiting";
        String type = "";

        if (nameBox.getText().isEmpty() || nameBox.getText().equals("Filename...")) {
            messageText("Filename is empty");
        } else {

            type = "AOEC";
            String dir = nameBox.getText() + ".aoec";
            String pass = passwordBox.getText();
            lista.add(new file(nameBox.getText(), type, dir));
            addTable(tablecontent6);
            textConverter textConverter = new textConverter(fileNameBox, jScrollPane6, tablecontent6, textArea, jProgressBar1);
            textConverter.saveTextToHex("txt/" + dir, (new StringBuffer(pass)));
            messageText("Entry added succerfully");
        }

        //getLista().clear();
        //filter("");
    }

}
