/**
 * 
 */
package application.business;

import org.hibernate.SessionFactory;
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
	 public static void main(String[] args) {
		 
	 }
}
