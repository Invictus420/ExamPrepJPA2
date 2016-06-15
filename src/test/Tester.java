/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import person.Employee;
import person.Grade;
import person.Person;
import person.Student;

/**
 *
 * @author Alex
 */
public class Tester {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public Tester() {
        this.emf = Persistence.createEntityManagerFactory("pu");
        this.em = emf.createEntityManager();
    }
    
    public void addPerson(String fn, String ln, Date bd, int age, boolean ism){
        Person p = new Person() {};
        p.setFirstName(fn);
        p.setLastName(ln);
        p.setBirthDate(bd);
        p.setAge(age);
        p.setIsMarried(ism);
        Grade g = new Grade();
        p.setG(g);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void addStudent(String fn, String ln, Date bd, int age, boolean ism, int matNr, Date md){
        Student p = new Student();
        p.setFirstName(fn);
        p.setLastName(ln);
        p.setBirthDate(bd);
        p.setAge(age);
        p.setIsMarried(ism);
        Grade g = new Grade();
        p.setG(g);
        p.setMatNr(matNr);
        p.setMatDate(md);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void addEmployee(String fn, String ln, Date bd, int age, boolean ism, int ssrnum, float wage, String tc){
        Employee p = new Employee();
        p.setFirstName(fn);
        p.setLastName(ln);
        p.setBirthDate(bd);
        p.setAge(age);
        p.setIsMarried(ism);
        Grade g = new Grade();
        p.setG(g);
        p.setSSRNum(ssrnum);
        p.setWage(wage);
        p.setTaxClass(tc);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void editGrade(int id, String name, int value){
        Grade g = em.find(Person.class, id).getG();
        g.setName(name);
        g.setValue(value);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public void newPartner(String ln, boolean ism, int id){
        Person p = em.find(Person.class, id);
        p.setLastName(ln);
        p.setIsMarried(ism);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public Student findStud(int id){
        return em.find(Student.class, id);
    }
    
    public Employee findEmp(int id){
        return em.find(Employee.class, id);
    }
    
    public void editWeedBudget(int id, float ganja){
        Employee e = em.find(Employee.class, id);
        e.setWage(ganja);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public void deletePerson(int id){
        em.getTransaction().begin();
        em.remove(em.find(Person.class, id));
        em.getTransaction().commit();
    }
    
    public void setSuper(int id, int sid){
        em.getTransaction().begin();
        em.find(Person.class, id).setSupervisor(em.find(Person.class, sid));
        em.find(Person.class, sid).addPerson(em.find(Person.class, id));
        em.getTransaction().commit();
    }
    
    public Person getSuper(int id){
        return em.find(Person.class, id).getSupervisor();
    }
    
    public List<Person> getMinions(int id){
        return em.find(Person.class, id).getPersons();
    }
}
