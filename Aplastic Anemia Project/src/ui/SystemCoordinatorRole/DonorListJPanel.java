/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemCoordinatorRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise_Directory;
import Business.Network.Network;
import Business.Organization.MedicalTechnicianOrganization;
import Business.Organization.Organization;
import Business.People.Donor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.System_Coordinator_Test_WorkRequest;
import Business.WorkQueue.WorkRequest;
import Magic.design.MyTableFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramsr
 */
public class DonorListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DonorListJPanel
     */
    
    private EcoSystem system;
    private Enterprise_Directory Enterprise_Directory;
    private Network network;
    private UserAccount userAccount;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public DonorListJPanel(UserAccount userAccount, EcoSystem system, Network network) {
        initComponents();
        this.userAccount = userAccount;
        this.system=system;
        this.network=network;
        
        tblDonors.getTableHeader().setDefaultRenderer(new MyTableFormat());
        tblHospital.getTableHeader().setDefaultRenderer(new MyTableFormat());
        tblAssignment.getTableHeader().setDefaultRenderer(new MyTableFormat());
        
        
        populateDonorTable();
        populateHospitalTable();
        populateRequestTable();
    }

    private void populateDonorTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblDonors.getModel();
        dtm.setRowCount(0);
        
        for (Donor donor : system.getDonorDirectory().getDonorList()){
            Object row[] = new  Object[4];
            row[0] = donor;
            row[1] = donor.getName();
            row[2] = donor.getContact();
            row[3] = donor.getStatus();
            
            dtm.addRow(row);
        }
    }
        
    private void populateHospitalTable(){
        
        DefaultTableModel dtm = (DefaultTableModel) tblHospital.getModel();
        dtm.setRowCount(0);
        
        System.out.println("list of enterprises:");
       // System.out.println(Enterprise_Directory.getEnterpriseList());
        System.out.println("list of enterprises ends");
        System.out.println(network.getName());
        for (Enterprise enterprise : network.getEnterprise_Directory().getEnterpriseList()){
            if(enterprise.getEnterpriseType().toString().equals("Hospital")){
                System.out.println("Hosp");
                Object[] row = new Object[2];
                row[0] = enterprise;
                row[1] = enterprise.getName();
                
                dtm.addRow(row);
            }
        }       
    }
        
    private void populateRequestTable(){
              
        DefaultTableModel model = (DefaultTableModel) tblAssignment.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            row[0] = request;
            
            row[1] = request.getDonor();
            row[2] = request.getSummary();
            row[3] = request.getEnterprise();
            row[4] = request.getStatus();
            row[5] = request.getActionDate();
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

        btnAssign = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonors = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHospital = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAssignment = new javax.swing.JTable();

        btnAssign.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Connect Donor to Hospital");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Assign a Hospital");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("List of approved donors");

        tblDonors.setBackground(new java.awt.Color(0, 0, 0));
        tblDonors.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblDonors.setForeground(new java.awt.Color(255, 255, 255));
        tblDonors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UID", "Name", "Contact", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonors.setGridColor(new java.awt.Color(0, 0, 0));
        tblDonors.setRowHeight(30);
        tblDonors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonorsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonors);

        tblHospital.setBackground(new java.awt.Color(0, 0, 0));
        tblHospital.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblHospital.setForeground(new java.awt.Color(255, 255, 255));
        tblHospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHospital.setGridColor(new java.awt.Color(0, 0, 0));
        tblHospital.setRowHeight(30);
        jScrollPane2.setViewportView(tblHospital);

        tblAssignment.setBackground(new java.awt.Color(0, 0, 0));
        tblAssignment.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblAssignment.setForeground(new java.awt.Color(255, 255, 255));
        tblAssignment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Number", "Donor UID", "Summary", "Hospital Name", "Status", "Requested Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAssignment.setGridColor(new java.awt.Color(0, 0, 0));
        tblAssignment.setRowHeight(30);
        jScrollPane4.setViewportView(tblAssignment);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1)
                        .addGap(448, 448, 448)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int row = tblDonors.getSelectedRow();
        int row1 = tblHospital.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the Donors Table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else if (row1 < 0) {
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the Hospital Table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
            //JOptionPane.showMessageDialog(null, "Please select a row from the Hospital table", "Warning", JOptionPane.WARNING_MESSAGE);
            //return;
        }
        else{
            WorkRequest request = new System_Coordinator_Test_WorkRequest();
            if(request.getDonor() == null)
            request.setDonor((Donor) tblDonors.getValueAt(row, 0));
            if(request.getDonor().getStatus().equals("Government Approved"))
            {

                request.setEnterprise((Enterprise) tblHospital.getValueAt(row1, 0));
                Organization org = null;
                Enterprise enterprise = (Enterprise) tblHospital.getValueAt(row1, 0);
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof MedicalTechnicianOrganization) {
                        org = organization;
                        break;
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(request);
                    System.out.println(org.getName());
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    JOptionPane.showMessageDialog(null,new JLabel(  "<html><b>Request sent successfully!</b></html>")
                        , "Info", JOptionPane.INFORMATION_MESSAGE);
                    request.setActionDate(new Date());
                    request.setUserAccount(userAccount);
                    request.getDonor().setStatus("Assigned to Hospital"); // Donor's Status changed
                    request.setAssigned("Hospital Pool");
                    request.setSummary("Requested for Donation");
                    request.setStatus("Assigned to Hospital"); // WorkRequest Status changed
                    populateDonorTable();
                    populateRequestTable();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No organization present", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Donor is already assigned to a Hospital.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnAssignActionPerformed

    private void tblDonorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonorsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblDonorsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAssignment;
    private javax.swing.JTable tblDonors;
    private javax.swing.JTable tblHospital;
    // End of variables declaration//GEN-END:variables
}
