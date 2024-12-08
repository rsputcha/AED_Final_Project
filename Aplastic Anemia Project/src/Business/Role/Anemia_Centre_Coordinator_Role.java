/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Anemia_Centre_Organization;
import Business.Organization.Organization;
import javax.swing.JPanel;
import ui.Anemia_Centre_Coordinator_Role.Anemia_Centre_Coordinator_WorkAreaJPanel;

/**
 *
 * @author deepakreddy
 */
public class Anemia_Centre_Coordinator_Role extends Role {
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new Anemia_Centre_Coordinator_WorkAreaJPanel(account, (Anemia_Centre_Organization) organization, enterprise, business, network);
    }
}
