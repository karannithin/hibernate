package com.wipro.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Get Hibernate Session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Start Transaction
        Transaction transaction = session.beginTransaction();

        // Create Student object
        Student student = new Student("Madhan");

        // Save to database
        session.save(student);

        // Commit and close session
        transaction.commit();
        session.close();

        System.out.println("Student inserted successfully!");

        // Close the Hibernate session factory when the application ends
        HibernateUtil.getSessionFactory().close();
    }
}