/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import java.util.ArrayList;
import javax.management.relation.Role;

/**
 *
 * @author saiteja
 */
public class Bone_Marrow_Bank_Enterprise {
    public Bone_Marrow_Bank_Enterprise(String name){
        super(name,EnterpriseType.BoneMarrowBank);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
