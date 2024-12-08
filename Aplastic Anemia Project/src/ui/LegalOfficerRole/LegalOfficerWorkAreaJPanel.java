/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.LegalOfficerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.LegalOfficerOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author ramsr
 */
public class LegalOfficerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LegalOfficerWorkAreaJPanel
     */
    private UserAccount userAccount;
    boolean a = true;
    DoctorOrganization doctorOrganization;
    private LegalOfficerOrganization legalofficerorganization;
    private Enterprise enterprise;
    private EcoSystem system;
    private Network network;
    
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public LegalOfficerWorkAreaJPanel(UserAccount account, LegalOfficerOrganization legalofficerorganization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        this.system = system;
        this.userAccount = account;
        this.legalofficerorganization = legalofficerorganization;
        this.enterprise = enterprise;
        this.system = business;
        this.network = network;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userProcessContainer = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        BtnProfile = new javax.swing.JLabel();
        BtnManageRequests = new javax.swing.JLabel();
        BtnConsent = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        userProcessContainer.setBackground(new java.awt.Color(255, 153, 153));
        userProcessContainer.setLayout(new java.awt.CardLayout());
        add(userProcessContainer, java.awt.BorderLayout.CENTER);

        Header.setBackground(new java.awt.Color(0, 0, 0));
        Header.setPreferredSize(new java.awt.Dimension(800, 50));
        Header.setLayout(new java.awt.GridLayout());

        BtnProfile.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnProfile.setForeground(new java.awt.Color(255, 255, 255));
        BtnProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnProfile.setText("Profile");
        BtnProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProfileMouseClicked(evt);
            }
        });
        Header.add(BtnProfile);

        BtnManageRequests.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnManageRequests.setForeground(new java.awt.Color(255, 255, 255));
        BtnManageRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnManageRequests.setText("Manage Requests");
        BtnManageRequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnManageRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnManageRequestsMouseClicked(evt);
            }
        });
        Header.add(BtnManageRequests);

        BtnConsent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnConsent.setForeground(new java.awt.Color(255, 255, 255));
        BtnConsent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnConsent.setText("Check Acceptance Status");
        BtnConsent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConsent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnConsentMouseClicked(evt);
            }
        });
        Header.add(BtnConsent);

        add(Header, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);    
    }
    
    public void clickmenu(JPanel h1, JPanel h2, int numberbool){
        
        if(numberbool == 1){
            
            h1.setBackground(new Color(70,55,37));
            h2.setBackground(new Color(216,99,1));        
        }
        else{
            h1.setBackground(new Color(216,99,1));
            h2.setBackground(new Color(70,55,37));   
        }  
    }
    
    private void BtnProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProfileMouseClicked
        // TODO add your handling code here:
        ManageLegalOfficerProfile manageLegalOfficerProfile = new ManageLegalOfficerProfile(userAccount,legalofficerorganization,enterprise);
        userProcessContainer.add("ManageLegalOfficerProfile",manageLegalOfficerProfile);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_BtnProfileMouseClicked

    private void BtnManageRequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnManageRequestsMouseClicked
        // TODO add your handling code here:
        ManageLegalOfficerRequestJPanel manageLegalOfficerRequest = new ManageLegalOfficerRequestJPanel(system, userAccount, legalofficerorganization, enterprise);
        userProcessContainer.add("ManageLegalOfficerRequestJPanel",manageLegalOfficerRequest);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_BtnManageRequestsMouseClicked

    private void BtnConsentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConsentMouseClicked
        // TODO add your handling code here:
        PatientConsentJPanel patientConsentJPanel = new PatientConsentJPanel(system, userAccount, network);
        userProcessContainer.add("PatientConsentJPanel",patientConsentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_BtnConsentMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnConsent;
    private javax.swing.JLabel BtnManageRequests;
    private javax.swing.JLabel BtnProfile;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
