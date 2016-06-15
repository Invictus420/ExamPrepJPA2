/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import javax.persistence.Persistence;

/**
 *
 * @author Alex
 */
public class Test {
    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
        Tester test = new Tester();
        test.addStudent("david", "faggot", new Date(), 1, true, 123, new Date());
        test.addStudent("Faggot", "david", new Date(), 1, true, 123, new Date());
        test.addStudent("Awesome", "Alex", new Date(), 1, true, 123, new Date());
        test.setSuper(1, 2);
        test.setSuper(3, 2);
        System.out.println(test.getSuper(1).toString());
        System.out.println(test.getMinions(2));
    }
}
