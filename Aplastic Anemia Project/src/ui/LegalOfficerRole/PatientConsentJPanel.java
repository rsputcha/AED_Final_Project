/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.LegalOfficerRole;

import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramsr
 */
public class PatientConsentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientConsentJPanel
     */
    private EcoSystem system;
    private UserAccount userAccount;
    private Network network;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public PatientConsentJPanel(EcoSystem system, UserAccount userAccount, Network network) {
        initComponents();
        this.system = system;
        this.userAccount = userAccount;
        this.network = network;
        tblPatientConsent.getTableHeader().setDefaultRenderer(new MyTableFormat());
        populatePatientConsentTable();
    }

    public void populatePatientConsentTable() {
        DefaultTableModel model = (DefaultTableModel) tblPatientConsent.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getPatient();
            row[2] = request.getPatient().getName();
            // row[3] = request.getPatient().getContact();
            row[3] = request.getPatient().getEmailID();
            row[4] = request.getStatus();

            model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblConsent = new javax.swing.JLabel();
        btnConsentForm = new javax.swing.JButton();
        btnSi8gn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientConsent = new javax.swing.JTable();
        btnPatientAgreement = new javax.swing.JButton();
        btnDisapproval = new javax.swing.JButton();
        btnApproval = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Treatment Consent Letter Status");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1578, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, -1));

        lblConsent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        add(lblConsent, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 180, 180));

        btnConsentForm.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnConsentForm.setText("Display Consent Form");
        btnConsentForm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsentForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsentFormActionPerformed(evt);
            }
        });
        add(btnConsentForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 220, 40));

        btnSi8gn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnSi8gn.setText("Sign the form");
        btnSi8gn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSi8gn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSi8gnActionPerformed(evt);
            }
        });
        add(btnSi8gn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 150, 40));

        tblPatientConsent.setBackground(new java.awt.Color(0, 0, 0));
        tblPatientConsent.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblPatientConsent.setForeground(new java.awt.Color(255, 255, 255));
        tblPatientConsent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Number", "Patient ID", "Patient Name", "Patient email", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatientConsent.setFocusable(false);
        tblPatientConsent.setGridColor(new java.awt.Color(0, 0, 0));
        tblPatientConsent.setRowHeight(30);
        jScrollPane1.setViewportView(tblPatientConsent);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 1150, 190));

        btnPatientAgreement.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnPatientAgreement.setText("Patient Agreement");
        btnPatientAgreement.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPatientAgreement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientAgreementActionPerformed(evt);
            }
        });
        add(btnPatientAgreement, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 200, 40));

        btnDisapproval.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnDisapproval.setText("Reject");
        btnDisapproval.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDisapproval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisapprovalActionPerformed(evt);
            }
        });
        add(btnDisapproval, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 210, 40));

        btnApproval.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnApproval.setText("Approve");
        btnApproval.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnApproval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovalActionPerformed(evt);
            }
        });
        add(btnApproval, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 210, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsentFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsentFormActionPerformed
        // TODO add your handling code here:
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("organ_Agreement.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img1.getScaledInstance(lblConsent.getWidth(), lblConsent.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lblConsent.setIcon(imageIcon);
    }//GEN-LAST:event_btnConsentFormActionPerformed

    private void btnSi8gnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi8gnActionPerformed
        // TODO add your handling code here:
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("organ_Agreement_DonorReceiverAdvocate.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img1.getScaledInstance(lblConsent.getWidth(), lblConsent.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lblConsent.setIcon(imageIcon);

    }//GEN-LAST:event_btnSi8gnActionPerformed

    private void btnPatientAgreementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientAgreementActionPerformed
        // TODO add your handling code here:
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("organ_Agreement_Donor.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img1.getScaledInstance(lblConsent.getWidth(), lblConsent.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lblConsent.setIcon(imageIcon);
    }//GEN-LAST:event_btnPatientAgreementActionPerformed

    private void btnDisapprovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisapprovalActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblPatientConsent.getSelectedRow();
        String email = (String) tblPatientConsent.getValueAt(selectedRow, 3);

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, new JLabel("<html><b>Please select a row from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

            // JOptionPane.showMessageDialog(null,"Please select a row", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            WorkRequest request = (WorkRequest) tblPatientConsent.getValueAt(selectedRow, 0);

            request.setStatus("Legally Disapproved");
            request.setUserAccount(userAccount);
            userAccount.getWorkQueue().getWorkRequestList().add(request);

            dB4OUtil.storeSystem(system);
            populatePatientConsentTable();
            JOptionPane.showMessageDialog(null, new JLabel("<html><b> Legally Disapproved!</b></html>"), "Info", JOptionPane.INFORMATION_MESSAGE);

            //JOptionPane.showMessageDialog(null,"Legally Disapproved", "Info", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(email);

            String fromEmail = "anchitha0913@gmail.com"; // Sender email
            String password = "eekabpucdsvhobrw"; // Sender email password

            // Set email properties
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            // Authenticate sender
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            // Create email session
            Session session = Session.getInstance(props, auth);

            try {
                // Create email message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(fromEmail));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject("Rejected Notification");
                message.setText("Your request has been rejected");

                // Send email message
                Transport.send(message);

                System.out.println("Email sent successfully.");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }//GEN-LAST:event_btnDisapprovalActionPerformed

    private void btnApprovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovalActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatientConsent.getSelectedRow();
        String email = (String) tblPatientConsent.getValueAt(selectedRow, 3);

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, new JLabel("<html><b>Please select a row from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

            // JOptionPane.showMessageDialog(null,"Please select a row", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            WorkRequest request = (WorkRequest) tblPatientConsent.getValueAt(selectedRow, 0);

            request.setStatus("Legally Approved. Passing to BoneMarrowBank");
            //request.setUserAccount(userAccount);
            //userAccount.getWorkQueue().getWorkRequestList().add(request);
            dB4OUtil.storeSystem(system);
            populatePatientConsentTable();

            //JOptionPane.showMessageDialog(null,"Legally Approved Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, new JLabel("<html><b>Legally approved successfully!</b></html>"), "Info", JOptionPane.INFORMATION_MESSAGE);

            Enterprise ent = null;
            Organization org = null;

            for (Enterprise enterprise : network.getEnterprise_Directory().getEnterpriseList()) {
                if (enterprise.getEnterpriseType().toString().equals("BoneMarrowBank")) {

                    ent = enterprise;
                    System.out.println(enterprise);
                    break;
                }
            }

            for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof Bone_Marrow_Bank_Organization) {
                    org = organization;
                    break;
                }
            }

            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(request);
                System.out.println(org.getName() + "Orgcheck");
            } else {
                JOptionPane.showMessageDialog(null, "No organization present", "Error", JOptionPane.ERROR_MESSAGE);
            }

            UserAccount userAc = null;
            for (UserAccount userAcc : org.getUserAccountDirectory().getUserAccountList()) {
                userAc = userAcc;
                userAc.getWorkQueue().getWorkRequestList().add(request);
                break;
            }
            System.out.println(email);

            String fromEmail = "anchitha0913@gmail.com"; // Sender email
            String password = "eekabpucdsvhobrw"; // Sender email password

            // Set email properties
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            // Authenticate sender
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            // Create email session
            Session session = Session.getInstance(props, auth);

            try {
                // Create email message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(fromEmail));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject("Approval Notification");
                message.setText("Your request has been approved and passed to LiverBank");

                // Send email message
                Transport.send(message);

                System.out.println("Email sent successfully.");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

    }//GEN-LAST:event_btnApprovalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproval;
    private javax.swing.JButton btnConsentForm;
    private javax.swing.JButton btnDisapproval;
    private javax.swing.JButton btnPatientAgreement;
    private javax.swing.JButton btnSi8gn;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConsent;
    private javax.swing.JTable tblPatientConsent;
    // End of variables declaration//GEN-END:variables
}