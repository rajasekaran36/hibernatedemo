package com.kgisl.raja;
import com.kgisl.raja.model.Department;
import com.kgisl.raja.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student student = new Student();

        student.setId(70);
        student.setName("Mandd");
        student.setAge(23);

        session.save(student);

        transaction.commit();

       /*  transaction = session.beginTransaction();

        Department department = new Department();
        department.setId(400);
        department.setName("ECE");
        department.setStartyear(2008);
        session.persist(department);
        transaction.commit(); */
        
        System.out.println("Data Saved");
        session.close();
        sessionFactory.close();
    }
}
