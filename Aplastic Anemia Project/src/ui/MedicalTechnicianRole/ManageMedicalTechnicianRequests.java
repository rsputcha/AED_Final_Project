/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.MedicalTechnicianRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.HLA.PersonHLA;
import Business.Network.Network;
import Business.Organization.Bone_Marrow_Bank_Organization;
import Business.Organization.MedicalTechnicianOrganization;
import Business.Organization.Organization;
import Business.People.Donor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import Magic.design.MyTableFormat;
import java.awt.Color;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramsr
 */
public class ManageMedicalTechnicianRequests extends javax.swing.JPanel {

    /**
     * Creates new form ManageMedicalTechnicianRequests
     */
    private EcoSystem system;
    private UserAccount userAccount;
    private MedicalTechnicianOrganization medTechOrganization;
    private Enterprise enterprise;
    private Network network;
    private Enterprise ep;
    private Organization org;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public ManageMedicalTechnicianRequests(EcoSystem system, UserAccount userAccount, MedicalTechnicianOrganization medTechOrganization, Enterprise enterprise, Network network) {
        initComponents();
        this.medTechOrganization = medTechOrganization;
        this.enterprise = enterprise;
        this.system = system;
        this.userAccount = userAccount;
        this.network = network;

        tblOrganisationDonors.getTableHeader().setDefaultRenderer(new MyTableFormat());
        tblMedTechDonors.getTableHeader().setDefaultRenderer(new MyTableFormat());
        populateOrganizationDonorTable();
        populateMedTechDonorTable();
    }

    public void populateOrganizationDonorTable(){
        
        DefaultTableModel model = (DefaultTableModel)tblOrganisationDonors.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : medTechOrganization.getWorkQueue().getWorkRequestList()){
            request.setStatus(request.getStatus().replaceAll("Plasma", "BoneMarrow"));
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSummary();
            row[2] = request.getDonor();
            row[3] = request.getDonor().getName();
            row[4] = request.getDonor().getContact();
            row[5] = request.getStatus();
            
            model.addRow(row);
        }
    }
    

    public void populateMedTechDonorTable(){
        DefaultTableModel model = (DefaultTableModel)tblMedTechDonors.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            request.setStatus(request.getStatus().replaceAll("Plasma", "BoneMarrow"));
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getDonor();
            row[2] = request.getDonor().getName();
            //row[3] = request.getDonor().getContact();
            row[3] = String.join(", ",request.getDonor().getHLA().getHlaValuesList());
            row[4] = request.getUserAccount().getUsername();
            row[5] = request.getStatus();
             
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

        checkBoneMarrow = new javax.swing.JCheckBox();
        buttonAddMarrow = new javax.swing.JButton();
        btnAssignMedTech = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganisationDonors = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        buttonMarrowDonated = new javax.swing.JButton();
        buttonProcessRequest = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textRequest = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        checkBP = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        checkTest = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedTechDonors = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        checkPulse = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        buttonBoneMarrowDiscard = new javax.swing.JButton();
        txtHLAList = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkBoneMarrow.setBackground(new java.awt.Color(0, 0, 0));
        checkBoneMarrow.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        checkBoneMarrow.setForeground(new java.awt.Color(255, 255, 255));
        checkBoneMarrow.setEnabled(false);
        checkBoneMarrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoneMarrowActionPerformed(evt);
            }
        });
        add(checkBoneMarrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 560, 20, 20));

        buttonAddMarrow.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        buttonAddMarrow.setText("Add Marrow to Bank");
        buttonAddMarrow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonAddMarrow.setBorderPainted(false);
        buttonAddMarrow.setEnabled(false);
        buttonAddMarrow.setSelected(true);
        buttonAddMarrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddMarrowActionPerformed(evt);
            }
        });
        add(buttonAddMarrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 210, 40));

        btnAssignMedTech.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnAssignMedTech.setText("Assign To Me");
        btnAssignMedTech.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAssignMedTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignMedTechActionPerformed(evt);
            }
        });
        add(btnAssignMedTech, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 160, 30));

        tblOrganisationDonors.setBackground(new java.awt.Color(0, 0, 0));
        tblOrganisationDonors.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblOrganisationDonors.setForeground(new java.awt.Color(255, 255, 255));
        tblOrganisationDonors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Number", "Summary", "Donor UID", "Donor Name", "Contact", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrganisationDonors.setGridColor(new java.awt.Color(0, 0, 0));
        tblOrganisationDonors.setRowHeight(30);
        jScrollPane1.setViewportView(tblOrganisationDonors);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1120, 140));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel5.setText("Health check");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, 20));

        buttonMarrowDonated.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        buttonMarrowDonated.setText("Marrow donated by the donor");
        buttonMarrowDonated.setBorder(new javax.swing.border.MatteBorder(null));
        buttonMarrowDonated.setBorderPainted(false);
        buttonMarrowDonated.setEnabled(false);
        buttonMarrowDonated.setSelected(true);
        buttonMarrowDonated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMarrowDonatedActionPerformed(evt);
            }
        });
        add(buttonMarrowDonated, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 300, 40));

        buttonProcessRequest.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        buttonProcessRequest.setText("Process the request");
        buttonProcessRequest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonProcessRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcessRequestActionPerformed(evt);
            }
        });
        add(buttonProcessRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 210, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel3.setText("Blood Pressure Check");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));

        textRequest.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        textRequest.setBorder(null);
        textRequest.setEnabled(false);
        add(textRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 170, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel4.setText("Pulse Check");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, -1, 20));
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(668, 80, 120, 100));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel9.setText("Request Number:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 1240, 10));

        checkBP.setBackground(new java.awt.Color(0, 0, 0));
        checkBP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        checkBP.setForeground(new java.awt.Color(255, 255, 255));
        checkBP.setEnabled(false);
        checkBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBPActionPerformed(evt);
            }
        });
        add(checkBP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 20, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setText("Tests on Marrow for other infections");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, 360, -1));

        checkTest.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        checkTest.setForeground(new java.awt.Color(255, 255, 255));
        checkTest.setEnabled(false);
        checkTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTestActionPerformed(evt);
            }
        });
        add(checkTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 30, 30));

        tblMedTechDonors.setBackground(new java.awt.Color(0, 0, 0));
        tblMedTechDonors.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblMedTechDonors.setForeground(new java.awt.Color(255, 255, 255));
        tblMedTechDonors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Number", "Donor UID", "Donor Name", "HLA", "Assigned to", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedTechDonors.setGridColor(new java.awt.Color(0, 0, 0));
        tblMedTechDonors.setRowHeight(30);
        tblMedTechDonors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMedTechDonorsMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblMedTechDonors);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 1070, 120));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Of Voluntary Bone Marrow Donors");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 511, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Manage Donor Request - Medical Technician");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(617, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1660, -1));

        checkPulse.setBackground(new java.awt.Color(0, 0, 0));
        checkPulse.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        checkPulse.setForeground(new java.awt.Color(255, 255, 255));
        checkPulse.setEnabled(false);
        add(checkPulse, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 20, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setText("HLA List");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, -1, 30));

        buttonBoneMarrowDiscard.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        buttonBoneMarrowDiscard.setText("Discard the donated Marrow");
        buttonBoneMarrowDiscard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonBoneMarrowDiscard.setBorderPainted(false);
        buttonBoneMarrowDiscard.setEnabled(false);
        buttonBoneMarrowDiscard.setSelected(true);
        buttonBoneMarrowDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBoneMarrowDiscardActionPerformed(evt);
            }
        });
        add(buttonBoneMarrowDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, 290, 40));

        txtHLAList.setText(" ");
        txtHLAList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHLAListActionPerformed(evt);
            }
        });
        add(txtHLAList, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 310, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoneMarrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoneMarrowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoneMarrowActionPerformed

    private void buttonAddMarrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddMarrowActionPerformed
        // TODO add your handling code here:
        // BloodGroup bloodGroup = new BloodGroup(txtBloodGroup.getText());
        int selectedRow = tblMedTechDonors.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Kindly select a row!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(!checkBoneMarrow.isSelected()){
            checkBoneMarrow.setBorder(BorderFactory.createLineBorder(Color.RED));
            checkBoneMarrow.setForeground(Color.red);
            // JOptionPane.showMessageDialog(null, "Kindly Test for other Infections!", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Kindly do the Test for other infections!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

        }
        else if(txtHLAList.getText().equals(null)){
            txtHLAList.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtHLAList.setForeground(Color.red);
            // JOptionPane.showMessageDialog(null, "Kindly select a Blood Group!", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Kindly select a HLA Type!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

        }
        else{
            for(Enterprise ent : network.getEnterprise_Directory().getEnterpriseList()){
                System.out.println("You are being monitored");
                System.out.println(ent.getEnterpriseType().toString());
                if(ent.getEnterpriseType().toString().equals("BoneMarrowBank")){
                    ep = ent;
                }
            }
            if(ep == null){
                JOptionPane.showMessageDialog(null, new JLabel("<html><b>"
                    + " There is no BoneMarrow Bank!"
                    + "</b></html>"),
                "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        for (Organization org: ep.getOrganizationDirectory().getOrganizationList()){
            System.out.println(org.getClass().getTypeName().toString()+" asit");
            if(org.getClass().getTypeName().toString().equals("Business.Organization.Bone_Marrow_Bank_Organization")){
                org =org;
            }
        }
        WorkRequest request = (WorkRequest)tblMedTechDonors.getValueAt(selectedRow, 0);

        try {
            org.getAllHLAs().add(PersonHLA.createHLA(String.valueOf(txtHLAList.getText())));
            PersonHLA h = new PersonHLA();
            h.updateHLAlist(txtHLAList.getText());
            ((Bone_Marrow_Bank_Organization)org).getInventory().HLACountAdd(h);
        }
        catch( NullPointerException ex   )
        { System.out.println("");
        }

        request.setStatus("BoneMarrow added to Bank");

        dB4OUtil.storeSystem(system);

        populateOrganizationDonorTable();
        populateMedTechDonorTable();

        JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>BoneMarrow added to the bank!</b></html>"));

        buttonAddMarrow.setEnabled(false);
        buttonBoneMarrowDiscard.setEnabled(false);
        }
        dB4OUtil.storeSystem(system);

    }//GEN-LAST:event_buttonAddMarrowActionPerformed

    private void btnAssignMedTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignMedTechActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrganisationDonors.getSelectedRow();

        if (selectedRow < 0){
            //JOptionPane.showMessageDialog(null, "Please select a row first!" );
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

            return;
        }

        else{
            WorkRequest request = (WorkRequest)tblOrganisationDonors.getValueAt(selectedRow, 0);
            //request.setReceiver(userAccount);

            if(request.getStatus().equals("Assigned to Hospital"))
            {
                request.setStatus("Assigned to MedTech" + userAccount.getUsername());
                request.setUserAccount(userAccount);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
            else{

                JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Work Request is already in progress!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

                //JOptionPane.showMessageDialog(null, "Work Request is already assigned!" );
            }

            dB4OUtil.storeSystem(system);

            populateOrganizationDonorTable();
            populateMedTechDonorTable();
        }
    }//GEN-LAST:event_btnAssignMedTechActionPerformed

    private void buttonMarrowDonatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMarrowDonatedActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedTechDonors.getSelectedRow();

        if (selectedRow < 0){

            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a Request Number from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

            //JOptionPane.showMessageDialog(null, "Please select a row first!" );
            return;
        }
        if (!checkBP.isSelected()) {
            checkBP.setBorder(BorderFactory.createLineBorder(Color.RED));
            checkBP.setForeground(Color.red);
        }
        if (!checkTest.isSelected()) {
            checkTest.setBorder(BorderFactory.createLineBorder(Color.RED));
            checkTest.setForeground(Color.red);
        }
        if (!checkPulse.isSelected()) {
            checkPulse.setBorder(BorderFactory.createLineBorder(Color.RED));
            checkPulse.setForeground(Color.red);
        }
        else if( !checkBP.isSelected()  || !checkTest.isSelected()  ||  !checkPulse.isSelected())
        {   JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Kindly do the Health Check of the Donor before the BoneMarrow Donation</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

            //JOptionPane.showMessageDialog(null, "Kindly do the Heatlth Check of the Donor before the Donation!" , "Error", JOptionPane.ERROR_MESSAGE);
        }

        else{
            WorkRequest request1 = (WorkRequest)tblMedTechDonors.getValueAt(selectedRow, 0);
            //       Donor donor = null;
            //        for(Donor dnr: system.getDonorDirectory().getDonorList()){
                //            if(dnr.getDonorID().equals(request1.getDonor().getDonorID())){
                    //                donor = dnr;
                    //            }
                //        }
            request1.setStatus("BoneMarrow Donated");

            //request1.getDonor().setStatus("BoneMarrow Donated");
            dB4OUtil.storeSystem(system);

            populateOrganizationDonorTable();
            populateMedTechDonorTable();

            JOptionPane.showMessageDialog(null, new JLabel("<html><b>Bone Marrow Donated!</b></html>"));

            for(Donor dnr: system.getDonorDirectory().getDonorList()){
                if(dnr.getDonorID().equals(request1.getDonor().getDonorID())){
                    dnr.setLastDonationDate(new Date());
                    dnr.setStatus("BoneMarrow Donated");
                    System.out.println(String.valueOf(dnr.getLastDonationDate())+" last donation date");
                }
            }
            //        populateMedTechDonorTable();
            buttonMarrowDonated.setEnabled(false);
            txtHLAList.setEnabled(false);
            buttonAddMarrow.setEnabled(true);
            buttonBoneMarrowDiscard.setEnabled(true);
            checkBoneMarrow.setEnabled(true);

            populateMedTechDonorTable();

        }
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_buttonMarrowDonatedActionPerformed

    private void buttonProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcessRequestActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblMedTechDonors.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

            // JOptionPane.showMessageDialog(null, "Please select a row first!" );
            return;
        }
        else
        {
            WorkRequest request = (WorkRequest)tblMedTechDonors.getValueAt(selectedRow, 0);

            if(request.getStatus().contains("Assigned to MedTech")){
                textRequest.setText( String.valueOf(tblOrganisationDonors.getValueAt(selectedRow, 0)));
                checkBP.setEnabled(true);
                checkTest.setEnabled(true);
                checkPulse.setEnabled(true);
                buttonMarrowDonated.setEnabled(true);
                txtHLAList.setText(tblMedTechDonors.getValueAt(selectedRow, 3).toString());
            }
            else if(request.getStatus().contains("BoneMarrow Donated")){
                JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Sir!!!!<br>BoneMarrow is already Donated</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(request.getStatus().contains("BoneMarrow Discarded")) {
                JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please check the status!<br>BoneMarrow is already discarded</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{

                JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Work Request is already in progress!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);

                //JOptionPane.showMessageDialog(null, "Request is already processed!" );
            }
        }
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_buttonProcessRequestActionPerformed

    private void checkBPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBPActionPerformed

    private void checkTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkTestActionPerformed

    private void tblMedTechDonorsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedTechDonorsMousePressed
        // TODO add your handling code here:
        int selectedRow = tblMedTechDonors.getSelectedRow();
        WorkRequest request = null;
        if(selectedRow >= 0) {
            request = (WorkRequest)tblMedTechDonors.getValueAt(selectedRow, 0);
            if(request.getStatus().equals("BoneMarrow Donated")) {
                buttonMarrowDonated.setEnabled(false);
                txtHLAList.setEnabled(false);
                buttonAddMarrow.setEnabled(true);
                buttonBoneMarrowDiscard.setEnabled(true);
                checkBoneMarrow.setEnabled(true);
            }
            else {
                buttonMarrowDonated.setEnabled(false);
                txtHLAList.setEnabled(false);
                buttonAddMarrow.setEnabled(false);
                buttonBoneMarrowDiscard.setEnabled(false);
                checkBoneMarrow.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tblMedTechDonorsMousePressed

    private void buttonBoneMarrowDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBoneMarrowDiscardActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMedTechDonors.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Please select a row first!" );
            return;
        }
        else
        {
            WorkRequest request = (WorkRequest)tblMedTechDonors.getValueAt(selectedRow, 0);
            request.setStatus("BoneMarrow Discarded");
            populateOrganizationDonorTable();
            populateMedTechDonorTable();
            JOptionPane.showMessageDialog(null, new JLabel("<html><b>BoneMarrow Discarded!</b></html>"));

            buttonAddMarrow.setEnabled(false);
            buttonBoneMarrowDiscard.setEnabled(false);

            dB4OUtil.storeSystem(system);
        }
    }//GEN-LAST:event_buttonBoneMarrowDiscardActionPerformed

    private void txtHLAListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHLAListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHLAListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignMedTech;
    private javax.swing.JButton buttonAddMarrow;
    private javax.swing.JButton buttonBoneMarrowDiscard;
    private javax.swing.JButton buttonMarrowDonated;
    private javax.swing.JButton buttonProcessRequest;
    private javax.swing.JCheckBox checkBP;
    private javax.swing.JCheckBox checkBoneMarrow;
    private javax.swing.JCheckBox checkPulse;
    private javax.swing.JCheckBox checkTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblMedTechDonors;
    private javax.swing.JTable tblOrganisationDonors;
    private javax.swing.JTextField textRequest;
    private javax.swing.JTextField txtHLAList;
    // End of variables declaration//GEN-END:variables
}
