/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alex
 */
@Entity
public class Employee extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public int getSSRNum() {
        return SSRNum;
    }

    public void setSSRNum(int SSRNum) {
        this.SSRNum = SSRNum;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }
    
    private int SSRNum;
    private float wage;
    private String taxClass;
            

}
