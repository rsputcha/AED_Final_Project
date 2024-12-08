/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.MedicalTechnicianRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.MedicalTechnicianOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author ramsr
 */
public class MedicalTechnicianWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MedicalTechnicianWorkAreaJPanel
     */
    boolean a = true;
    private UserAccount userAccount;
    private MedicalTechnicianOrganization medhTechOrg;
    private Enterprise enterprise;
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private Network network;
    
    public MedicalTechnicianWorkAreaJPanel(UserAccount account, MedicalTechnicianOrganization pathoorganization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        this.userAccount = account;
        this.medhTechOrg = pathoorganization;
        this.enterprise = enterprise;
        this.system = business;
        this.network = network;
    }

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
        BtnManageRequest = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        userProcessContainer.setBackground(new java.awt.Color(255, 153, 153));
        userProcessContainer.setLayout(new java.awt.CardLayout());
        add(userProcessContainer, java.awt.BorderLayout.CENTER);

        Header.setBackground(new java.awt.Color(15, 29, 52));
        Header.setPreferredSize(new java.awt.Dimension(800, 70));
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

        BtnManageRequest.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnManageRequest.setForeground(new java.awt.Color(255, 255, 255));
        BtnManageRequest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnManageRequest.setText("Manage Request");
        BtnManageRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnManageRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnManageRequestMouseClicked(evt);
            }
        });
        Header.add(BtnManageRequest);

        add(Header, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProfileMouseClicked
        // TODO add your handling code here:

        ManageMedicalTechnicianProfile manageMedTechProfile = new ManageMedicalTechnicianProfile(userAccount,medhTechOrg,enterprise);
        userProcessContainer.add("ManageMedTechProfile",manageMedTechProfile);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_BtnProfileMouseClicked

    private void BtnManageRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnManageRequestMouseClicked
        // TODO add your handling code here:
        ManageMedicalTechnicianRequests manageMedTechRequest = new ManageMedicalTechnicianRequests(system,userAccount,medhTechOrg,enterprise, network);
        userProcessContainer.add("ManageMedTechRequests", manageMedTechRequest);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_BtnManageRequestMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnManageRequest;
    private javax.swing.JLabel BtnProfile;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}