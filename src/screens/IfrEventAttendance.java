/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import dao.EventsDAO;
import dao.UserDAO;
import dao.UserHasEventsDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static screens.Login.userId;
import support.Email;
import support.Formatacao;

/**
 *
 * @author dudub
 */
public class IfrEventAttendance extends javax.swing.JFrame {

    /**
     * Creates new form IfrEventAttend
     */
    public IfrEventAttendance()  {

        initComponents();
        Formatacao.formatarData(tfdEventDate);
        tfdIdEvents.setText("0");
        tfdIdUser.setText("0");
        tfdIdEvents.setEnabled(false);
        tfdIdUser.setEnabled(false);
        Formatacao.formatarData(tfdEventDate1);
        tfdIdEvents1.setText("0");
        tfdIdEvents1.setEnabled(false);
        Formatacao.formatarCpf(tfdCpfs);
        tfdMode.setEnabled(false);
        btnOfflineMode.setEnabled(true);
        btnOnlineMode.setEnabled(false);
        tfdMode.setText("Online");
        checkBoxParticipantWithAccount.setEnabled(false);
    }
    
    public static int idS;
    public static int idE;
    public static boolean btn = true;
        File file = new File("/C:/Users/dudub/Documents/NetBeansProjects/ArquiteturaGerenciaEventos/src/text/insertuserhasevents.txt");
    File file1 = new File("/C:/Users/dudub/Documents/NetBeansProjects/ArquiteturaGerenciaEventos/src/text/insertuserhasevents.txt");
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUsersAttendance = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdUserSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAvailableEvents = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        tfdEventDate = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        tfdIdEvents = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfdIdUser = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAvailableEvents1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tfdIdEvents1 = new javax.swing.JTextField();
        tfdEventDate1 = new javax.swing.JFormattedTextField();
        tfdCpfs = new javax.swing.JFormattedTextField();
        btnOnlineMode = new javax.swing.JButton();
        btnOfflineMode = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfdMode = new javax.swing.JTextField();
        checkBoxParticipantWithAccount = new javax.swing.JCheckBox();
        btnSyncData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("Search Users");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Select User");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Confirm Attendance");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        TableUsersAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "CPF", "Phone"
            }
        ));
        jScrollPane2.setViewportView(TableUsersAttendance);

        jButton2.setText("Select Event");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Registered Users to the Event");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Registered Users Attendance");

        jLabel1.setText("Event Date");

        jButton1.setText("Search Events");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableAvailableEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Description", "Location", "Category", "Event Date", "Start Time", "End Time"
            }
        ));
        jScrollPane3.setViewportView(tableAvailableEvents);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        tfdEventDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdEventDateActionPerformed(evt);
            }
        });

        jLabel13.setText("Id Of Selected Event");

        tfdIdEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdIdEventsActionPerformed(evt);
            }
        });

        jLabel14.setText("Id Of Selected User");

        tfdIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdIdUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdIdEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(jButton2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(91, 91, 91)
                                        .addComponent(jButton4))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tfdUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 128, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(tfdEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3)
                                .addComponent(tfdUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tfdIdEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(tfdIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registered Users Attendance", jPanel1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Check-In Attendance");

        jLabel5.setText("Event Date");

        tableAvailableEvents1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Description", "Location", "Category", "Event Date", "Start Time", "End Time"
            }
        ));
        jScrollPane4.setViewportView(tableAvailableEvents1);

        jButton6.setText("Search Events");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Select Event");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setText("CPF");

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnClose1.setText("Close");
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Id Of Selected Event");

        tfdIdEvents1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdIdEvents1ActionPerformed(evt);
            }
        });

        tfdEventDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdEventDate1ActionPerformed(evt);
            }
        });

        tfdCpfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCpfsActionPerformed(evt);
            }
        });

        btnOnlineMode.setText("Online Mode");
        btnOnlineMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnlineModeActionPerformed(evt);
            }
        });

        btnOfflineMode.setText("Offline Mode");
        btnOfflineMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfflineModeActionPerformed(evt);
            }
        });

        jLabel7.setText("Selected Mode");

        checkBoxParticipantWithAccount.setText("Participant With Account");
        checkBoxParticipantWithAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxParticipantWithAccountActionPerformed(evt);
            }
        });

        btnSyncData.setText("Sync Data");
        btnSyncData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSyncDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdEventDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnOnlineMode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOfflineMode))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdMode, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdCpfs, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(checkBoxParticipantWithAccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdIdEvents1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButton7))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSyncData)
                        .addGap(31, 31, 31)
                        .addComponent(btnClose1)))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOnlineMode)
                    .addComponent(btnOfflineMode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(tfdEventDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfdIdEvents1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(checkBoxParticipantWithAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCpfs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose1)
                    .addComponent(btnSyncData))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Check-In Attendance", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tfdEventDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEventDateActionPerformed

    }//GEN-LAST:event_tfdEventDateActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnClose1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new EventsDAO().popularTabela3(tableAvailableEvents1,tfdEventDate1.getText());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new EventsDAO().popularTabela3(tableAvailableEvents,tfdEventDate.getText());         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdIdEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdIdEventsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdIdEventsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String idString = String.valueOf(tableAvailableEvents.getValueAt(tableAvailableEvents.getSelectedRow(), 0));
        idS = Integer.parseInt(idString);
        tfdIdEvents.setText(""+idS);
    }//GEN-LAST:event_jButton2ActionPerformed

     
    
    private void tfdIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdIdUserActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          new UserDAO().popularTabelaEventAttendance(TableUsersAttendance,tfdUserSearch.getText(),idS);      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String idString = String.valueOf(TableUsersAttendance.getValueAt(TableUsersAttendance.getSelectedRow(), 0));
        idE = Integer.parseInt(idString);
        tfdIdUser.setText(""+idE);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            new EventsDAO().saveAttendance(idE,idS);
            JOptionPane.showMessageDialog(this, "Attendance Confirmed");
            String email = "";
            String description = "";
            Email em= new Email();
            UserDAO udao = new UserDAO();
            email = udao.returnEmailUserId(idE);
            EventsDAO edao = new EventsDAO();
            description = edao.returnEventDescription(idS);
            em.enviarEmailAttendanceInscricao(email, description);
            DefaultTableModel model1 = new DefaultTableModel();
            DefaultTableModel tMOdel1 = (DefaultTableModel) TableUsersAttendance.getModel();
            tMOdel1.setRowCount(0);
            tfdIdUser.setText("");
        } catch (MessagingException ex) {
            Logger.getLogger(IfrEventAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfdIdEvents1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdIdEvents1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdIdEvents1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String idString = String.valueOf(tableAvailableEvents1.getValueAt(tableAvailableEvents1.getSelectedRow(), 0));
        idS = Integer.parseInt(idString);
        tfdIdEvents1.setText(""+idS);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tfdEventDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEventDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdEventDate1ActionPerformed

    private void tfdCpfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCpfsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCpfsActionPerformed
/*
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
   
    }//GEN-LAST:event_jButton8ActionPerformed

    */
    
    
    public void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        UserDAO udao = new UserDAO();
        EventsDAO edao = new EventsDAO();
        int user = 0;
        int event = Integer.parseInt(tfdIdEvents1.getText());
        String cpf = tfdCpfs.getText().replace(".", "").replace("-", "");
        
        if (btn) {
        if (tfdCpfs.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill the CPF field!");
        } else {
          if (udao.consultCpf(cpf)) {
              try {
                  System.out.println("entrei aqui 4");
                  user = udao.consultIdUser(cpf);
                  System.out.println("entrei aqui 5");
                  edao.insertUserHasEvents(user, event);
                  System.out.println("entrei aqui 6");
                  JOptionPane.showMessageDialog(this, "Attendance Confirmed");
                  String email = "";
                  String description = "";
                  Email em= new Email();
                  idE = udao.consultIdUser(cpf);
                  email = udao.returnEmailUserId(idE);
                  description = edao.returnEventDescription(event);
                  em.enviarEmailAttendanceInscricao(email, description);
                  tfdCpfs.setText("");
              } catch (MessagingException ex) {
                  Logger.getLogger(IfrEventAttendance.class.getName()).log(Level.SEVERE, null, ex);
              }
          } else {
                  System.out.println("entrei aqui");
                  udao.insertUserOnlyCpf(cpf);
                  System.out.println("entrei aqui 1");
                  int id = udao.consultIdUser(cpf);
                  System.out.println("entrei aqui 2 e o valor do id é " + id);
                  udao.insertUserHasEventsUserOnlyCpf(id, event);
                  System.out.println("entrei aqui 3");
                  JOptionPane.showMessageDialog(this, "Attendance Confirmed! \nRemember to complete the registration after the event! \nRegister is required to generate the certificates!" );
                  System.out.println("entrei aqui 7");

          };
        }
        } else {
            System.out.println("O VALOR DE BTN É " + btn);
            if (cpf.equals("") || tfdIdEvents1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "All fields should be filled!");
        } else {
                System.out.println("o valor do cpf é" + cpf);
                System.out.println("O VALOR DE BTN É " + btn);
             if (checkBoxParticipantWithAccount.isSelected()) {
                 //File file = new File("/C:/Users/dudub/Documents/NetBeansProjects/ArquiteturaGerenciaEventos/src/text/test.txt");
                 try {
                     if (!file.exists()) {
                         file.createNewFile();
                     }
                     FileWriter fw = new FileWriter(file, true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     user = udao.consultIdUserLocalHost(cpf);
                     if (user == 0) {
                         JOptionPane.showMessageDialog(null, "User with the cpf informed is not registered!");
                     } else {
                     bw.write("INSERT INTO userhasevents VALUES ("
                        + "default,'Y','Registered','Y'," + user + "," + event + ")");
                     bw.newLine();
                     bw.close();
                     JOptionPane.showMessageDialog(null, "Attendance Confirmed!");
                     tfdCpfs.setText("");
                     }
                     
                 } catch (IOException ex) {
                     Logger.getLogger(IfrEventAttendance.class.getName()).log(Level.SEVERE, null, ex);
                 }
             } else {
                 // aqui vai ser inserção de apenas o cpf e depois o usuario preenche o restante do cadastro
                 //File file1 = new File("/C:/Users/dudub/Documents/NetBeansProjects/ArquiteturaGerenciaEventos/src/text/test1.txt");
                 try {
                     if (!file1.exists()) {
                         file1.createNewFile();
                     }
                     FileWriter fw1 = new FileWriter(file1, true);
                     BufferedWriter bw2 = new BufferedWriter(fw1);
                     
                     int maxid = udao.returnLastUserId();
                    
                     
                     maxid = maxid + 1;
                     
                     bw2.write("INSERT INTO userr VALUES (default,NULL,NULL,NULL,'"+cpf+"',NULL,NULL,NULL,NULL,NULL)");
                     bw2.newLine();
                     bw2.write("INSERT INTO userhasevents VALUES ("
                        + "default,'Y','Registered','Y'," + maxid + "," + event + ")");
                     bw2.newLine();
                     bw2.close();
                     
                     JOptionPane.showMessageDialog(this, "Attendance Confirmed! \nRemember to complete the registration after the event! \nRegister is required to generate the certificates!" );
              } catch (IOException ex) {
                     Logger.getLogger(IfrEventAttendance.class.getName()).log(Level.SEVERE, null, ex);
                 } 
             
            }
        }
        }
        
    }                                        
    
    
    
    private void btnOnlineModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnlineModeActionPerformed
              btnOnlineMode.setEnabled(false);
       btnOfflineMode.setEnabled(true);
       tfdMode.setText("Online");
       checkBoxParticipantWithAccount.setEnabled(false);
       btn = true;
    }//GEN-LAST:event_btnOnlineModeActionPerformed

    private void btnOfflineModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfflineModeActionPerformed
       btnOnlineMode.setEnabled(true);
       btnOfflineMode.setEnabled(false);
       tfdMode.setText("Offline");
       checkBoxParticipantWithAccount.setEnabled(true);
       btn = false;
    }//GEN-LAST:event_btnOfflineModeActionPerformed

    private void checkBoxParticipantWithAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxParticipantWithAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxParticipantWithAccountActionPerformed

    private void btnSyncDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSyncDataActionPerformed
        FileInputStream stream = null;
        UserHasEventsDAO uheDAO = new UserHasEventsDAO();
        FileInputStream stream1 = null;
        boolean x = false;
        try {
            stream = new FileInputStream("/C:/Users/dudub/Documents/NetBeansProjects/ArquiteturaGerenciaEventos/src/text/insertuserhasevents.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IfrEventAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);

            try {
                String linha = br.readLine();
                 if (linha == null) {
                JOptionPane.showMessageDialog(null, "There is no data into file!");
                } else {
                while(linha != null) {
                uheDAO.InsertModeOff(linha);
                linha = br.readLine();
                }
                JOptionPane.showMessageDialog(null, "Data Synchronized Sucessfully");
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                RandomAccessFile raf1 = new RandomAccessFile(file1, "rw");
                raf.setLength(0);
                raf1.setLength(0);
                }
            } catch (IOException ex) {
                 JOptionPane.showMessageDialog(null, "Data Synchronized Sucessfully");   
                //Logger.getLogger(IfrEventAttendance.class.getName()).log(Level.SEVERE, null, ex);    
            }
    }//GEN-LAST:event_btnSyncDataActionPerformed

   
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IfrEventAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IfrEventAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IfrEventAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IfrEventAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new IfrEventAttendance().setVisible(true);
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUsersAttendance;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnOfflineMode;
    private javax.swing.JButton btnOnlineMode;
    private javax.swing.JButton btnSyncData;
    private javax.swing.JCheckBox checkBoxParticipantWithAccount;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableAvailableEvents;
    private javax.swing.JTable tableAvailableEvents1;
    private javax.swing.JFormattedTextField tfdCpfs;
    private javax.swing.JFormattedTextField tfdEventDate;
    private javax.swing.JFormattedTextField tfdEventDate1;
    private javax.swing.JTextField tfdIdEvents;
    private javax.swing.JTextField tfdIdEvents1;
    private javax.swing.JTextField tfdIdUser;
    private javax.swing.JTextField tfdMode;
    private javax.swing.JTextField tfdUserSearch;
    // End of variables declaration//GEN-END:variables
}
