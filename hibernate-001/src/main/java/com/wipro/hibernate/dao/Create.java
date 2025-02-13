package com.wipro.hibernate.dao;

import com.wipro.hibernate.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.wipro.hibernate.utilities.SessionFactoryProvider;

public class Create {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            // Creating a new Employee object
            Employee emp = new Employee(101, "John Doe");
            session.persist(emp);

            t.commit();
            session.close();
            sessionFactory.close();

            System.out.println("Employee record inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
        }
    }
}

