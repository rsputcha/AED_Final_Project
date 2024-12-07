/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import java.util.ArrayList;
import javax.management.relation.Role;

/**
 *
 * @author saiteja
 */
public class SystemCoordinatorOrganization extends Organization {
     public SystemCoordinatorOrganization() {
        super(Organization.Type.SystemCoordinator.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SystemCoordinatorRole());
        return roles;
    }
    
}