/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.HLA;

import java.util.ArrayList;

/**
 *
 * @author saiteja
 */
public class PersonHLA {
    private ArrayList<HLAType> hlaList = new ArrayList();
    
    public PersonHLA() {
        hlaList = new ArrayList<>();
    }
    
    public enum HLAType{
        HLA_A("HLA_A"),
        HLA_B("HLA_B"),
        HLA_C("HLA_C"),
        HLA_DR("HLA_DR"),
        HLA_DBQ1("HLA_DBQ1");
        
        private String value;
        private HLAType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    
}
