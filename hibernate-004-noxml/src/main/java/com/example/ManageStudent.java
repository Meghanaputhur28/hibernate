package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class ManageStudent {
    public static void main(String[] args) {
        // Hibernate Properties 
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/student2");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "Sirisha*1234#");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");

        // Hibernate Configuration
        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        // Register the Student entity
        configuration.addAnnotatedClass(Student.class); 

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        // Insert data into the database
        session.beginTransaction();
        Student student = new Student("Sirisha");
        session.persist(student);
        session.getTransaction().commit();

        System.out.println("Student saved successfully!");

        session.close();
        sessionFactory.close();
    }
}