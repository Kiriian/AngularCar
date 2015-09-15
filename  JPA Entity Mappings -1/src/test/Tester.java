/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Book;
import entity.Customer;
import enums.CustomerType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jeanette
 */
public class Tester
{

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        Book b = new Book();
        b.setTitle("Thing");
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        
        Customer c = new Customer();
        c.setCustomerType(CustomerType.RUSTY);
        c.setFirstname("Jeanette");
        c.setLastname("Møller");
        c.addHobby("Painting");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
}
