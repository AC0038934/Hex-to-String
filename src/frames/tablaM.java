/*
future updates:
change "delete row" style
change "take screenshot" style
change "chooser file" style
block main windows if message appears
block multiple main windows
change popup menu background color when its selected
decrypt text animation (matrix)
show and hide password content
 */
package frames;

import build.style;
import build.textConverter;
import build.extraTools;
import build.tableController;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kuro
 */
public class tablaM extends javax.swing.JFrame {

    //private ArrayList<file> lista = new ArrayList();
    public DefaultTableModel model;
    DefaultComboBoxModel modeloCbx = new DefaultComboBoxModel();    
    //private Object contenido[] = new Object[99];
    //private String Switch = "OFF";
    private int x, y;
    private boolean rowSelected = false;
    int index;

    public tablaM() {
        initComponents();
        
        runConfig();
        tableController tableController = new tableController( tablecontent6);
        tableController.loadAllTable();
        
    }


     public class Colorir<String> extends JLabel implements ListCellRenderer {
        int conta = 5;
        public Colorir() {
            super();
            setOpaque(true);
        }
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
 
              Object texto = modeloCbx.getElementAt(index);

            if (texto != null && conta == (texto.toString().length())) {
                setBackground(Color.RED);
            } else {
                setBackground(Color.BLACK);
            }
            setBorder(null);
            if (isSelected) {
                setBackground(Color.RED);
            }

            return this;
        }
    }   
     
     
     
    public void runConfig() {

typeCbx.setRenderer(new Colorir<String>());

//jLabel8.setText(String.valueOf(typeCbx.getSelectedItem()));
        
        style style = new style();
        style.buttonStyle(addBtn);
        style.buttonStyle(resetBtn);
//        style.buttonStyle(exitBtn);
        style.buttonStyle(deleteBtn);
        style.buttonStyle(decryptBtn);
        style.buttonStyle(cryptBtn);
        style.buttonStyle(selectBtn);
        style.buttonStyle(copyTextBtn);
        style.buttonStyle(randomPassBtn);

//        style.tableSetting(tablecontent, jScrollPane1);
//        style.tableSetting(tablecontent3, jScrollPane3);
//        style.tableSetting(tablecontent4, jScrollPane4);
//        style.tableSetting(tablecontent5, jScrollPane5);
        style.tableSetting(tablecontent6, jScrollPane6);

        style.JtextBorder(nameBox);
        style.JtextBorder(fileNameBox);
        style.JtextBorder(passwordBox);

        style.progressBarStyle(jProgressBar1);

        deleteSelectRowBtn.setOpaque(true);
        deleteSelectRowBtn.setBackground(new java.awt.Color(24, 25, 29));
        jPopupMenu1.setBorder(BorderFactory.createLineBorder(Color.white));
        extraTools.setBorder(BorderFactory.createLineBorder(Color.white));
        trueCryptBtn.setOpaque(true);
        trueCryptBtn.setBackground(new java.awt.Color(24, 25, 29));
        copyTXTBtn.setOpaque(true);
        copyTXTBtn.setBackground(new java.awt.Color(24, 25, 29));
        takeSSBtn.setOpaque(true);
        takeSSBtn.setBackground(new java.awt.Color(24, 25, 29));

//        jScrollPane3.setVisible(false);
//        jScrollPane4.setVisible(false);
//        jScrollPane5.setVisible(false);
//        jScrollPane1.setVisible(false);

        File dir = new File("txt");
        dir.mkdir();
        File dir2 = new File("tb");
        dir2.mkdir();
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, (new java.awt.Color(255, 255, 255))));

    }

    public void resetFilePanel(ButtonGroup buttonGroup1, JTextField passwordBox, JTextField nameBox, JTextField fileNameBox, JTextArea textArea) {
        nameBox.setText("Filename...");
        buttonGroup1.clearSelection();
        passwordBox.setText("Encrypted Text...");
        fileNameBox.setText("");
        textArea.setText("");
        length.setText("Length: 0 ");
        typeCbx.setSelectedIndex(0);
    }

//    public void deleteRow() {
//        if (jScrollPane1.isVisible() == true) {
//            model = (DefaultTableModel) tablecontent.getModel();
//            do {
//                ((DefaultTableModel) tablecontent.getModel()).removeRow(tablecontent.getSelectedRows()[0]);
//            } while (tablecontent.getSelectedRowCount() > 0);
//        } else if (jScrollPane3.isVisible() == true) {
//            model = (DefaultTableModel) tablecontent3.getModel();
//            do {
//                ((DefaultTableModel) tablecontent3.getModel()).removeRow(tablecontent3.getSelectedRows()[0]);
//            } while (tablecontent3.getSelectedRowCount() > 0);
//        } else if (jScrollPane4.isVisible() == true) {
//            model = (DefaultTableModel) tablecontent4.getModel();
//            do {
//                ((DefaultTableModel) tablecontent4.getModel()).removeRow(tablecontent4.getSelectedRows()[0]);
//            } while (tablecontent4.getSelectedRowCount() > 0);
//        } else if (jScrollPane5.isVisible() == true) {
//            model = (DefaultTableModel) tablecontent5.getModel();
//            do {
//                ((DefaultTableModel) tablecontent5.getModel()).removeRow(tablecontent5.getSelectedRows()[0]);
//            } while (tablecontent5.getSelectedRowCount() > 0);
//        } else if (jScrollPane6.isVisible() == true) {
//            model = (DefaultTableModel) tablecontent6.getModel();
//            do {
//                ((DefaultTableModel) tablecontent6.getModel()).removeRow(tablecontent6.getSelectedRows()[0]);
//            } while (tablecontent6.getSelectedRowCount() > 0);
//        }
//
//    }

//    public void deleteRowQuestion() {
//        String value = "";
//        if (tablecontent.getSelectedRowCount() >= 2 || tablecontent3.getSelectedRowCount() >= 2 || tablecontent4.getSelectedRowCount() >= 2
//                || tablecontent5.getSelectedRowCount() >= 2 || tablecontent6.getSelectedRowCount() >= 2) {
//            int choice = JOptionPane.showOptionDialog(null,
//                    "Delete selected items?",
//                    "Delete?",
//                    JOptionPane.YES_NO_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null, null, null);
//
//            // interpret the user's choice
//            if (choice == JOptionPane.YES_OPTION) {
//                deleteRow();
//
//            }
//        } else {
//
//            if (jScrollPane1.isVisible() == true) {
//                model = (DefaultTableModel) tablecontent.getModel();
//                value = (String.valueOf(model.getDataVector().elementAt(tablecontent.getSelectedRow())));
//            } else if (jScrollPane3.isVisible() == true) {
//                model = (DefaultTableModel) tablecontent3.getModel();
//                value = (String.valueOf(model.getDataVector().elementAt(tablecontent3.getSelectedRow())));
//            } else if (jScrollPane4.isVisible() == true) {
//                model = (DefaultTableModel) tablecontent4.getModel();
//                value = (String.valueOf(model.getDataVector().elementAt(tablecontent4.getSelectedRow())));
//            } else if (jScrollPane5.isVisible() == true) {
//                model = (DefaultTableModel) tablecontent5.getModel();
//                value = (String.valueOf(model.getDataVector().elementAt(tablecontent5.getSelectedRow())));
//            } else if (jScrollPane6.isVisible() == true) {
//                model = (DefaultTableModel) tablecontent6.getModel();
//                value = (String.valueOf(model.getDataVector().elementAt(tablecontent6.getSelectedRow())));
//            }
//
//            int choice = JOptionPane.showOptionDialog(null,
//                    "Delete: " + value + " ?",
//                    "Delete?",
//                    JOptionPane.YES_NO_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null, null, null);
//
//            // interpret the user's choice
//            if (choice == JOptionPane.YES_OPTION) {
//                deleteRow();
//
//            }
//        }
//    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        deleteSelectRowBtn = new javax.swing.JMenuItem();
        extraTools = new javax.swing.JPopupMenu();
        trueCryptBtn = new javax.swing.JMenuItem();
        copyTXTBtn = new javax.swing.JMenuItem();
        takeSSBtn = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        decryptBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablecontent6 = new javax.swing.JTable();
        jSeparator12 = new javax.swing.JSeparator();
        toolbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        newFilePanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        resetBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        nameBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        passwordBox = new javax.swing.JTextField();
        randomPassBtn = new javax.swing.JButton();
        length = new javax.swing.JLabel();
        typeCbx = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        encryptPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        cryptBtn = new javax.swing.JButton();
        selectBtn = new javax.swing.JButton();
        fileNameBox = new javax.swing.JTextField();
        copyTextBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();

        jPopupMenu1.setBackground(new java.awt.Color(0, 0, 0));
        jPopupMenu1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPopupMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        deleteSelectRowBtn.setBackground(new java.awt.Color(0, 0, 0));
        deleteSelectRowBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        deleteSelectRowBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteSelectRowBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/test.png"))); // NOI18N
        deleteSelectRowBtn.setText("Delete select item");
        deleteSelectRowBtn.setBorder(null);
        deleteSelectRowBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deleteSelectRowBtnMouseMoved(evt);
            }
        });
        deleteSelectRowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteSelectRowBtnMouseExited(evt);
            }
        });
        deleteSelectRowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectRowBtnActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteSelectRowBtn);

        extraTools.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        extraTools.setForeground(new java.awt.Color(255, 255, 255));

        trueCryptBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        trueCryptBtn.setForeground(new java.awt.Color(255, 255, 255));
        trueCryptBtn.setText("Open TrueCrypt");
        trueCryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trueCryptBtnActionPerformed(evt);
            }
        });
        extraTools.add(trueCryptBtn);

        copyTXTBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        copyTXTBtn.setForeground(new java.awt.Color(255, 255, 255));
        copyTXTBtn.setText("Copy Text");
        copyTXTBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTXTBtnActionPerformed(evt);
            }
        });
        extraTools.add(copyTXTBtn);

        takeSSBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        takeSSBtn.setForeground(new java.awt.Color(255, 255, 255));
        takeSSBtn.setText("Take Screenshot");
        takeSSBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeSSBtnActionPerformed(evt);
            }
        });
        extraTools.add(takeSSBtn);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("@nefasturri EncrypterTool v2");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePanel.setBackground(new java.awt.Color(0, 0, 0));
        tablePanel.setForeground(new java.awt.Color(0, 0, 0));
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Encrypted File List");
        tablePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 20));

        decryptBtn.setBackground(new java.awt.Color(0, 0, 0));
        decryptBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        decryptBtn.setForeground(new java.awt.Color(255, 255, 255));
        decryptBtn.setText("Decrypt");
        decryptBtn.setAutoscrolls(true);
        decryptBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        decryptBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decryptBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                decryptBtnMouseMoved(evt);
            }
        });
        decryptBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                decryptBtnMouseExited(evt);
            }
        });
        decryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptBtnActionPerformed(evt);
            }
        });
        tablePanel.add(decryptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 280, 26));

        deleteBtn.setBackground(new java.awt.Color(0, 0, 0));
        deleteBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deleteBtnMouseMoved(evt);
            }
        });
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        tablePanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 105, 26));

        jScrollPane6.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setBorder(null);
        jScrollPane6.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablecontent6.setBackground(new java.awt.Color(0, 0, 0));
        tablecontent6.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        tablecontent6.setForeground(new java.awt.Color(255, 255, 255));
        tablecontent6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Encryption", "URL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablecontent6.setToolTipText("");
        tablecontent6.setComponentPopupMenu(jPopupMenu1);
        tablecontent6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablecontent6.setGridColor(new java.awt.Color(0, 0, 0));
        tablecontent6.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tablecontent6.setSelectionForeground(new java.awt.Color(255, 51, 51));
        tablecontent6.getTableHeader().setReorderingAllowed(false);
        tablecontent6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tablecontent6FocusLost(evt);
            }
        });
        tablecontent6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecontent6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablecontent6MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablecontent6MouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tablecontent6);
        if (tablecontent6.getColumnModel().getColumnCount() > 0) {
            tablecontent6.getColumnModel().getColumn(0).setResizable(false);
            tablecontent6.getColumnModel().getColumn(1).setResizable(false);
            tablecontent6.getColumnModel().getColumn(2).setResizable(false);
            tablecontent6.getColumnModel().getColumn(3).setResizable(false);
        }

        tablePanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 400, 100));

        jSeparator12.setBackground(new java.awt.Color(24, 25, 29));
        jSeparator12.setForeground(new java.awt.Color(24, 25, 29));
        jSeparator12.setToolTipText("WWWWWWWWW");
        tablePanel.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 440, 10));

        mainPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 160, 470, 180));

        toolbar.setBackground(new java.awt.Color(24, 25, 29));
        toolbar.setToolTipText("");
        toolbar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toolbar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                toolbarMouseDragged(evt);
            }
        });
        toolbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toolbarMousePressed(evt);
            }
        });
        toolbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/if_close_1814098(3).png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/image/closePress.png"))); // NOI18N
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        toolbar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minimize.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minimizePress.png"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        toolbar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 20, 20));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("EncrypterTool v3 | 000000000.com");
        jLabel7.setToolTipText("");
        toolbar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 200, 20));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/freebsd_start_here_free_bsd-24.png"))); // NOI18N
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });
        toolbar.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 20));

        mainPanel.add(toolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 20));

        newFilePanel.setBackground(new java.awt.Color(0, 0, 0));
        newFilePanel.setForeground(new java.awt.Color(0, 0, 0));
        newFilePanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newFilePanelFocusLost(evt);
            }
        });
        newFilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resetBtn.setBackground(new java.awt.Color(0, 0, 0));
        resetBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                resetBtnMouseMoved(evt);
            }
        });
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetBtnMouseExited(evt);
            }
        });
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(0, 0, 0));
        addBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setAutoscrolls(true);
        addBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                addBtnMouseMoved(evt);
            }
        });
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBtnMouseExited(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        nameBox.setBackground(new java.awt.Color(0, 0, 0));
        nameBox.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        nameBox.setForeground(new java.awt.Color(255, 51, 51));
        nameBox.setText("Filename...");
        nameBox.setBorder(null);
        nameBox.setCaretColor(new java.awt.Color(255, 255, 255));
        nameBox.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        nameBox.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        nameBox.setSelectionColor(new java.awt.Color(255, 255, 255));
        nameBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameBoxFocusLost(evt);
            }
        });
        nameBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameBoxMouseExited(evt);
            }
        });
        nameBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameBoxKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Entry");

        passwordBox.setBackground(new java.awt.Color(0, 0, 0));
        passwordBox.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        passwordBox.setForeground(new java.awt.Color(255, 51, 51));
        passwordBox.setText("Encrypted Text...");
        passwordBox.setBorder(null);
        passwordBox.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordBox.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        passwordBox.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        passwordBox.setSelectionColor(new java.awt.Color(255, 255, 255));
        passwordBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordBoxFocusLost(evt);
            }
        });
        passwordBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passwordBoxMouseExited(evt);
            }
        });
        passwordBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordBoxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordBoxKeyTyped(evt);
            }
        });

        randomPassBtn.setBackground(new java.awt.Color(0, 0, 0));
        randomPassBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        randomPassBtn.setForeground(new java.awt.Color(255, 255, 255));
        randomPassBtn.setText("Generate key");
        randomPassBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        randomPassBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        randomPassBtn.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                randomPassBtnAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        randomPassBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                randomPassBtnMouseMoved(evt);
            }
        });
        randomPassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                randomPassBtnMouseExited(evt);
            }
        });
        randomPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomPassBtnActionPerformed(evt);
            }
        });

        length.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        length.setForeground(new java.awt.Color(255, 255, 255));
        length.setText("Length: 0");
        length.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        length.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        typeCbx.setBackground(new java.awt.Color(0, 0, 0));
        typeCbx.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        typeCbx.setForeground(new java.awt.Color(255, 255, 255));
        typeCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Comb", "Only Number", "Number + Letters" }));
        typeCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCbxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("AOEC Encryption");

        jSeparator11.setBackground(new java.awt.Color(24, 25, 29));
        jSeparator11.setForeground(new java.awt.Color(24, 25, 29));
        jSeparator11.setToolTipText("WWWWWWWWW");

        jLayeredPane1.setLayer(resetBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(addBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(nameBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(passwordBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(randomPassBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(length, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(typeCbx, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSeparator11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordBox)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(length, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nameBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(randomPassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(length, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomPassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(435, 435, 435))
        );

        newFilePanel.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -30, 440, 570));

        mainPanel.add(newFilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 20, 500, 140));

        encryptPanel.setBackground(new java.awt.Color(0, 0, 0));

        textArea.setBackground(new java.awt.Color(0, 0, 0));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        textArea.setForeground(new java.awt.Color(255, 51, 51));
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setCaretColor(new java.awt.Color(255, 255, 255));
        textArea.setComponentPopupMenu(extraTools);
        textArea.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        textArea.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(textArea);

        cryptBtn.setBackground(new java.awt.Color(0, 0, 0));
        cryptBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        cryptBtn.setForeground(new java.awt.Color(255, 255, 255));
        cryptBtn.setText("Encrypt/Save");
        cryptBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        cryptBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cryptBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cryptBtnMouseMoved(evt);
            }
        });
        cryptBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cryptBtnMouseExited(evt);
            }
        });
        cryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryptBtnActionPerformed(evt);
            }
        });

        selectBtn.setBackground(new java.awt.Color(0, 0, 0));
        selectBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        selectBtn.setForeground(new java.awt.Color(255, 255, 255));
        selectBtn.setText("Select");
        selectBtn.setAutoscrolls(true);
        selectBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        selectBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                selectBtnMouseMoved(evt);
            }
        });
        selectBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectBtnMouseExited(evt);
            }
        });
        selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });

        fileNameBox.setEditable(false);
        fileNameBox.setBackground(new java.awt.Color(0, 0, 0));
        fileNameBox.setFont(new java.awt.Font("Verdana", 1, 8)); // NOI18N
        fileNameBox.setForeground(new java.awt.Color(255, 255, 255));
        fileNameBox.setBorder(null);
        fileNameBox.setCaretColor(new java.awt.Color(255, 255, 255));
        fileNameBox.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        fileNameBox.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        fileNameBox.setSelectionColor(new java.awt.Color(255, 255, 255));
        fileNameBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fileNameBoxFocusLost(evt);
            }
        });
        fileNameBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileNameBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fileNameBoxMouseExited(evt);
            }
        });
        fileNameBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fileNameBoxKeyPressed(evt);
            }
        });

        copyTextBtn.setBackground(new java.awt.Color(0, 0, 0));
        copyTextBtn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        copyTextBtn.setForeground(new java.awt.Color(255, 255, 255));
        copyTextBtn.setText("Copy Text");
        copyTextBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        copyTextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyTextBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                copyTextBtnMouseMoved(evt);
            }
        });
        copyTextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyTextBtnMouseExited(evt);
            }
        });
        copyTextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTextBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Encrypter Tool");

        jProgressBar1.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setBorder(null);
        jProgressBar1.setBorderPainted(false);

        jSeparator9.setBackground(new java.awt.Color(24, 25, 29));
        jSeparator9.setForeground(new java.awt.Color(24, 25, 29));
        jSeparator9.setToolTipText("WWWWWWWWW");

        jSeparator10.setBackground(new java.awt.Color(24, 25, 29));
        jSeparator10.setForeground(new java.awt.Color(24, 25, 29));
        jSeparator10.setToolTipText("WWWWWWWWW");

        javax.swing.GroupLayout encryptPanelLayout = new javax.swing.GroupLayout(encryptPanel);
        encryptPanel.setLayout(encryptPanelLayout);
        encryptPanelLayout.setHorizontalGroup(
            encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encryptPanelLayout.createSequentialGroup()
                        .addComponent(fileNameBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encryptPanelLayout.createSequentialGroup()
                        .addComponent(cryptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyTextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(encryptPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(encryptPanelLayout.createSequentialGroup()
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        encryptPanelLayout.setVerticalGroup(
            encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptPanelLayout.createSequentialGroup()
                .addComponent(jSeparator10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(copyTextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cryptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(encryptPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 440, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 441, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("@nefasturri EncrypterTool v2\nkawia-nn.org");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        /*       
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
         */

    }//GEN-LAST:event_formMouseReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(tablaM.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        messageChoice messageChoice = new messageChoice(this, "Are you sure you want to exit EncrypterTool?");
        messageChoice.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void nameBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameBoxFocusLost
        //nameBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if (nameBox.getText().equals("")) {
            nameBox.setText("Filename...");
        }
    }//GEN-LAST:event_nameBoxFocusLost

    private void nameBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameBoxMouseClicked
        if (nameBox.getText().equals("Filename...")) {
            nameBox.setText("");
        }
        //nameBox.setBorder(BorderFactory.createLineBorder(new Color(51, 82, 112)));
    }//GEN-LAST:event_nameBoxMouseClicked

    private void nameBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameBoxKeyPressed

    }//GEN-LAST:event_nameBoxKeyPressed

    private void newFilePanelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newFilePanelFocusLost


    }//GEN-LAST:event_newFilePanelFocusLost

    private void nameBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameBoxMouseExited
//nameBox.setBorder(BorderFactory.createLineBorder(new java.awt.Color(24, 25, 29)));
    }//GEN-LAST:event_nameBoxMouseExited

    private void toolbarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_toolbarMousePressed

    private void toolbarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolbarMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_toolbarMouseDragged

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
        jLabel4.setEnabled(false);
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setEnabled(true);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
        jLabel3.setEnabled(false);
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setEnabled(true);
    }//GEN-LAST:event_jLabel3MouseExited

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
        tableController tableController = new tableController(   tablecontent6,  nameBox,  passwordBox,   jScrollPane6,  jLabel2, jProgressBar1);
        tableController.createFile();
        passwordBox.setText("Encrypted Text...");
        nameBox.setText("Filename...");
        tableController.saveAllTable();

    
    }//GEN-LAST:event_addBtnActionPerformed

    private void fileNameBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fileNameBoxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNameBoxFocusLost

    private void fileNameBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileNameBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNameBoxMouseClicked

    private void fileNameBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileNameBoxMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNameBoxMouseExited

    private void fileNameBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileNameBoxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNameBoxKeyPressed

    private void addBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseMoved
        style style = new style();
        style.buttonStyleON(addBtn);

    }//GEN-LAST:event_addBtnMouseMoved

    private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(addBtn);
    }//GEN-LAST:event_addBtnMouseExited

    private void resetBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseMoved
        style style = new style();
        style.buttonStyleON(resetBtn);
    }//GEN-LAST:event_resetBtnMouseMoved

    private void resetBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(resetBtn);
    }//GEN-LAST:event_resetBtnMouseExited

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetFilePanel(buttonGroup1, passwordBox, nameBox, fileNameBox, textArea);
   
    }//GEN-LAST:event_resetBtnActionPerformed

    private void tablecontent6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablecontent6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tablecontent6FocusLost

    private void tablecontent6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecontent6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablecontent6MouseClicked

    private void tablecontent6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecontent6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablecontent6MouseEntered

    private void tablecontent6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecontent6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablecontent6MouseReleased

    private void randomPassBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_randomPassBtnMouseMoved
        style style = new style();
        style.buttonStyleON(randomPassBtn);
    }//GEN-LAST:event_randomPassBtnMouseMoved

    private void randomPassBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_randomPassBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(randomPassBtn);
    }//GEN-LAST:event_randomPassBtnMouseExited

    private void randomPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomPassBtnActionPerformed
        extraTools extraTools = new extraTools();
        passwordBox.setText(extraTools.generatePassword(typeCbx.getSelectedItem().toString()));
        
        length.setText("Length: "+String.valueOf(passwordBox.getText().length()));
        

        

    }//GEN-LAST:event_randomPassBtnActionPerformed

    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
        textConverter textConverter = new textConverter(fileNameBox, jScrollPane6, tablecontent6, textArea, jProgressBar1);
        textConverter.chooserFile();
    }//GEN-LAST:event_selectBtnActionPerformed

    private void selectBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(selectBtn);
    }//GEN-LAST:event_selectBtnMouseExited

    private void selectBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectBtnMouseMoved
        style style = new style();
        style.buttonStyleON(selectBtn);
    }//GEN-LAST:event_selectBtnMouseMoved

    private void decryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptBtnActionPerformed
        textConverter textConverter = new textConverter(fileNameBox, jScrollPane6, tablecontent6, textArea, jProgressBar1);
        textConverter.chooserFilePasswordTable();

    }//GEN-LAST:event_decryptBtnActionPerformed

    private void decryptBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decryptBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(decryptBtn);
    }//GEN-LAST:event_decryptBtnMouseExited

    private void decryptBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decryptBtnMouseMoved
        style style = new style();
        style.buttonStyleON(decryptBtn);
    }//GEN-LAST:event_decryptBtnMouseMoved

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
//  filestate.setText(String.valueOf(tablecontent6.getValueAt(tablecontent6.getSelectedRow(), tablecontent6.getSelectedRow())));
//                         if(rowSelected == false){
//                     model = (DefaultTableModel)tablecontent6.getModel();
//                     rowSelected = true;
//                 }
//                 
//                 index = tablecontent6.getSelectedRow();
//                 if(index < model.getRowCount() -1){
//                     model.moveRow(index, index, index +1);
//                     tablecontent6.setRowSelectionInterval(index +1, index +1);
//                     tablecontent6.setSelectionBackground(Color.BLACK);
//                 }
    
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(deleteBtn);
    }//GEN-LAST:event_deleteBtnMouseExited

    private void deleteBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseMoved
        style style = new style();
        style.buttonStyleON(deleteBtn);
    }//GEN-LAST:event_deleteBtnMouseMoved

    private void cryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptBtnActionPerformed
        //saveChooserFile();
        textConverter textConverter = new textConverter(fileNameBox, jScrollPane6, tablecontent6, textArea, jProgressBar1);
        textConverter.saveChooserFile();

    }//GEN-LAST:event_cryptBtnActionPerformed

    private void cryptBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptBtnMouseExited

        style style = new style();
        style.buttonStyleOFF(cryptBtn);
    }//GEN-LAST:event_cryptBtnMouseExited

    private void cryptBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptBtnMouseMoved
        style style = new style();
        style.buttonStyleON(cryptBtn);
    }//GEN-LAST:event_cryptBtnMouseMoved

    private void copyTextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyTextBtnActionPerformed
        extraTools extraTools = new extraTools();
        extraTools.clipboardFunction(textArea);
    }//GEN-LAST:event_copyTextBtnActionPerformed

    private void copyTextBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyTextBtnMouseExited
        style style = new style();
        style.buttonStyleOFF(copyTextBtn);
    }//GEN-LAST:event_copyTextBtnMouseExited

    private void copyTextBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyTextBtnMouseMoved

        style style = new style();
        style.buttonStyleON(copyTextBtn);
    }//GEN-LAST:event_copyTextBtnMouseMoved

    private void passwordBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordBoxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordBoxKeyPressed

    private void passwordBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordBoxMouseExited
        //passwordBox.setBorder(BorderFactory.createLineBorder(new java.awt.Color(24, 25, 29)));
    }//GEN-LAST:event_passwordBoxMouseExited

    private void passwordBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordBoxMouseClicked
        if (passwordBox.getText().equals("Encrypted Text...")) {
            passwordBox.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_passwordBoxMouseClicked

    private void passwordBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordBoxFocusLost
        if (passwordBox.getText().equals("")) {
            passwordBox.setText("Encrypted Text...");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_passwordBoxFocusLost

    private void passwordBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordBoxKeyTyped
     length.setText("Length: "+String.valueOf(1+(passwordBox.getText().length())));
       
    }//GEN-LAST:event_passwordBoxKeyTyped

    private void randomPassBtnAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_randomPassBtnAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_randomPassBtnAncestorAdded

    private void typeCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCbxActionPerformed
        //jLabel8.setText(String.valueOf(typeCbx.getSelectedItem()));
    }//GEN-LAST:event_typeCbxActionPerformed

    private void takeSSBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeSSBtnActionPerformed
        extraTools extraTools = new extraTools();
        extraTools.saveScreenshot();
    }//GEN-LAST:event_takeSSBtnActionPerformed

    private void copyTXTBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyTXTBtnActionPerformed
        extraTools extraTools = new extraTools();
        extraTools.clipboardFunction(textArea);
    }//GEN-LAST:event_copyTXTBtnActionPerformed

    private void trueCryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trueCryptBtnActionPerformed
        extraTools extraTools = new extraTools();
        extraTools.TrueCrypt();
    }//GEN-LAST:event_trueCryptBtnActionPerformed

    private void deleteSelectRowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectRowBtnActionPerformed
        //        deleteRowQuestion();
    }//GEN-LAST:event_deleteSelectRowBtnActionPerformed

    private void deleteSelectRowBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSelectRowBtnMouseExited

    }//GEN-LAST:event_deleteSelectRowBtnMouseExited

    private void deleteSelectRowBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSelectRowBtnMouseMoved

    }//GEN-LAST:event_deleteSelectRowBtnMouseMoved

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        changelog changelog = new changelog();
        changelog.setVisible(true);
    }//GEN-LAST:event_logoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tablaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem copyTXTBtn;
    private javax.swing.JButton copyTextBtn;
    private javax.swing.JButton cryptBtn;
    private javax.swing.JButton decryptBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JMenuItem deleteSelectRowBtn;
    private javax.swing.JPanel encryptPanel;
    private javax.swing.JPopupMenu extraTools;
    private javax.swing.JTextField fileNameBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel length;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameBox;
    private javax.swing.JPanel newFilePanel;
    private javax.swing.JTextField passwordBox;
    private javax.swing.JButton randomPassBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton selectBtn;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tablecontent6;
    private javax.swing.JMenuItem takeSSBtn;
    private javax.swing.JTextArea textArea;
    private javax.swing.JPanel toolbar;
    private javax.swing.JMenuItem trueCryptBtn;
    private javax.swing.JComboBox<String> typeCbx;
    // End of variables declaration//GEN-END:variables

//    public javax.swing.JTable getTablecontent() {
//        return tablecontent;
//    }
//
//    public void setTablecontent(javax.swing.JTable tablecontent) {
//        this.tablecontent = tablecontent;
//    }
//
//    public javax.swing.JTable getTablecontent3() {
//        return tablecontent3;
//    }
//
//    public void setTablecontent3(javax.swing.JTable tablecontent3) {
//        this.tablecontent3 = tablecontent3;
//    }
//
//    public javax.swing.JTable getTablecontent4() {
//        return tablecontent4;
//    }
//
//    public void setTablecontent4(javax.swing.JTable tablecontent4) {
//        this.tablecontent4 = tablecontent4;
//    }
//
//    public javax.swing.JTable getTablecontent5() {
//        return tablecontent5;
//    }
//
//    public void setTablecontent5(javax.swing.JTable tablecontent5) {
//        this.tablecontent5 = tablecontent5;
//    }

    public javax.swing.JTable getTablecontent6() {
        return tablecontent6;
    }

    public void setTablecontent6(javax.swing.JTable tablecontent6) {
        this.tablecontent6 = tablecontent6;
    }



}
