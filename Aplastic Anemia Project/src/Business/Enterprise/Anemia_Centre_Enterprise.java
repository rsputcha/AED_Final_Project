/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import java.util.ArrayList;
import javax.management.relation.Role;

/**
 *
 * @author saiteja
 */
public class Anemia_Centre_Enterprise  extends Enterprise {
    
    public Anemia_Centre_Enterprise(String name){
        super(name,EnterpriseType.BloodCancerCentre);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
