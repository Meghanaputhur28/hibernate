package com.example.entity;

import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageStudent {
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageStudent ME = new ManageStudent();

		/* Add few employee records in database */
		Integer stdID1 = ME.addStudent("Zara", "Ali", 89);
		Integer stdID2 = ME.addStudent("Daisy", "Das", 78);
		Integer stdID3 = ME.addStudent("John", "Paul", 95);

		/* List down all the employees */
		ME.listStudents();

		/* Update employee's records */
		ME.updateStudent(stdID1, 5000);

		/* Delete an employee from the database */
		ME.deleteStudent(stdID2);

		/* List down new list of the employees */
		ME.listStudents();
	}

	private void updateStudent(Integer stdID1, int i) {
		// TODO Auto-generated method stub

	}

	private void listStudents() {
		// TODO Auto-generated method stub

	}

	/* Method to CREATE an employee in the database */
	public Integer addStudent(String fname, String lname, int marks) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer studentID = null;

		try {
			tx = session.beginTransaction();
			Student student = new Student(fname, lname, marks);
			studentID = (Integer) session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentID;
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List students = session.createQuery("FROM Student").list();
			for (Iterator iterator = students.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				System.out.print("First Name: " + student.getFirstName());
				System.out.print("  Last Name: " + student.getLastName());
				System.out.println("  Salary: " + student.getmarks());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer StudentID, int marks) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, StudentID);
			student.setSalary(marks);
			session.update(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE a student from the records */
	public void deleteStudent(Integer studentID) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, studentID);
			if (student != null) {
				session.delete(student);
				tx.commit();
			} else {
				System.out.println("Student with ID " + studentID + " not found.");
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
