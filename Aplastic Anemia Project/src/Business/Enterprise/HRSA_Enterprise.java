/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author saiteja
 */
public class HRSA_Enterprise extends Enterprise  {
    public HRSA_Enterprise(String name){
        super(name,Enterprise.EnterpriseType.HRSA);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
