package com.example;

import jakarta.persistence.*;

@Entity // This tells Hibernate it's an entity
@Table(name = "students") //table name
public class Student {

    @Id // 🔹 Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNumber;

    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

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