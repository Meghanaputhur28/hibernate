package com.example.entity;

public class Student {
	   private int id;
	   private String firstName; 
	   private String lastName;
	   private int marks;  

	   public Student() {}
	   public Student(String fname, String lname, int marks) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.marks = marks;
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   
	   public String getLastName() {
	      return lastName;
	   }
	   
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   
	   public int getmarks() {
	      return marks;
	   }
	   
	   public void setSalary( int marks ) {
	      this.marks = marks;
	   }
}