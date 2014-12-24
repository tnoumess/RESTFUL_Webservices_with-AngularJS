/**
 * 
 */
package application.business;

import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import application.model.Student;

import org.hibernate.cfg.Configuration;

/**
 * @author root
 *
 */
public class SetupDB {
	private static final SessionFactory sessionfactory;
	 static {
	        try {
	            sessionfactory = new Configuration().addResource("./resources/student.hbm.xml")
	            		.configure("./resources/hibernate.cfg.xml")
	                    .buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 public static  boolean SaveForm(Student s){
		 try {
			 
			System.out.println("inserting info");	
			Session session=sessionfactory.openSession();	
			Transaction transaction=session.beginTransaction();
			Student sb=new Student(s);
			session.save(sb);
			transaction.commit();
			System.out.println("Information successfully inserted!!!");
			return true;
			
		} catch (Exception e) {
			System.out.println("error during insertion");
			// TODO: handle exception
			return false;
		}
		 
		 		 
	 }
	 
	 
	 public static void main(String[] args) {
		 
		 Student s=new Student("studentId", "name", "major", "country");
		 SaveForm(s);
	 }
}
