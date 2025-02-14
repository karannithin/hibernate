package com.wipro.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ManageEmployee {
    public static void main(String[] args) {
    	 Configuration con = new Configuration().addAnnotatedClass(Employee.class);
         SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
         Session session = sf.openSession();
         Transaction tx = session.beginTransaction();

        // Adding Employees
        Employee emp1 = new Employee("Zara", "Ali", 1000);
        Employee emp2 = new Employee("Daisy", "Das", 5000);
        Employee emp3 = new Employee("John", "Paul", 10000);
        
        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);
        
        tx.commit();

        // Listing Employees
        listEmployees(session);

        // Updating Employee
        updateEmployee(session, emp1.getId(), 5000);

        // Deleting Employee
        deleteEmployee(session, emp2.getId());

        // Listing Employees after update and delete
        listEmployees(session);
    }

    public static void listEmployees(Session session) {
        Transaction tx = session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee1", Employee.class).list();
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getFirstName() + " " + employee.getLastName() + ", Salary: " + employee.getSalary());
        }
        tx.commit();
    }

    public static void updateEmployee(Session session, Integer employeeID, int newSalary) {
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeID);
        if (employee != null) {
            employee.setSalary(newSalary);
            session.update(employee);
        }
        tx.commit();
    }

    public static void deleteEmployee(Session session, Integer employeeID) {
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeID);
        if (employee != null) {
            session.delete(employee);
        }
        tx.commit();
    }
}