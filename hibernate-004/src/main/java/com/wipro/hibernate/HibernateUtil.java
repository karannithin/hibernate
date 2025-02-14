package com.wipro.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/student_db2")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "Noel@2003")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.hbm2ddl.auto", "update") // Auto-create/update tables
                    .setProperty("hibernate.show_sql", "true") // Show SQL queries in the console
                    .addAnnotatedClass(Student.class) // Register Student class
                    .buildSessionFactory();
        } catch (Exception ex) {
            throw new RuntimeException("SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}