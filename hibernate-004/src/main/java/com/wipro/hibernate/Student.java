package com.wipro.hibernate;

import jakarta.persistence.*;

@Entity  // Marks this as a Hibernate Entity
@Table(name = "student")  // Maps to "student" table in MySQL
public class Student {

    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment in MySQL
    private int rollNumber;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructors
    public Student() {}
    public Student(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
