/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author kuro
 */
public class style {

    public style() {
    }
    
    public void progressBarStyle(JProgressBar jProgressBar1){
       jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setForeground((new java.awt.Color(255, 51, 51)));
        jProgressBar1.setString("0%");
        jProgressBar1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(24, 25, 29)));
    }
        public void buttonStyle(JButton button){
                button.setContentAreaFilled(false);
        button.setOpaque(true);

    }
    
        public void buttonStyleOFF(JButton button){
        button.setBackground(new java.awt.Color(0, 0, 0));
    }
        public void buttonStyleON(JButton button){
        button.setBackground(new java.awt.Color(70, 70, 70));
    }
            public void JtextBorder(JTextField text){
        text.setBorder(BorderFactory.createLineBorder(Color.white));
       
    }
                public void tableSetting(JTable JTable, JScrollPane JScrollPane) {
        /////////////////////////Table1/////////////////////////
        JScrollPane.setBackground(new java.awt.Color(0, 0, 0));
        JScrollPane.setOpaque(false);
        JTable.setOpaque(false);
        ((DefaultTableCellRenderer) JTable.getDefaultRenderer(Object.class)).setOpaque(false);
        JScrollPane.getViewport().setOpaque(false);
        JScrollPane.setBorder(JTable.getBorder());
        JTableHeader header = JTable.getTableHeader();
        header.setForeground(Color.WHITE);
        JTable.getTableHeader().setOpaque(false);
        JTable.getTableHeader().setBackground(new java.awt.Color(0, 0, 0));

        //header.setBorder(new LineBorder(Color.decode("#006699"),2));
    }


    
}
