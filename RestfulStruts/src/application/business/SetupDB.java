/**
 * 
 */
package application.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Thierry Edson Noumessi
 * 
 * Persistence Object that provides access to the database.
 *
 */
public class SetupDB {
	/**
	 * Static element that initializes the database before use.
	 */
	private static final SessionFactory sessionfactory;
	 static {
	        try {System.out.println("before!!!");
	            sessionfactory = new Configuration().addResource("./resources/student.hbm.xml")
	            		.configure("./resources/hibernate.cfg.xml")
	                    .buildSessionFactory();
	            System.out.println("after");
	        } catch (Throwable ex) {System.out.println("In exception");
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 /**
	 * @param student
	 * @return true if the student has been registered
	 *         false if and error has occurred
	 */
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
	/**
	 * @param student
	 * @return true if the student has been registered
	 *         false if and error has occurred
	 */
	public static  boolean updateForm(Student s){
		 try {
			 
			System.out.println("inserting info");	
			Session session=sessionfactory.openSession();	
			Transaction transaction=session.beginTransaction();
			Student sb=new Student(s);
			System.out.println("before insertion");
			 Student q = (Student)session.get(Student.class, s.getStudentId());
			 q.setName(s.getName());
			 q.setMajor(s.getMajor());
			 q.setCountry(s.getcountry());
			 session.update(q);
			transaction.commit();
			System.out.println("Information successfully updated!!!");
			return true;
			
		} catch (Exception e) {
			System.out.println("error during insertion");
			// TODO: handle exception
			return false;
		}
		 
		 		 
	 }
	 /**
	 * @param Id
	 * @return true if the student with id= Id is in the database
	 *         false otherwise
	 */
	public static boolean IdInuse(final String Id) {
			
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from Student");	    
			List<Student> stud = query.list();
			
			List<String> list = new ArrayList<String>();
			if(stud!=null&&stud.size()>0){
				for (int i = 0; i < stud.size(); i++) {
					if(stud.get(i).getStudentId().equals(Id)){
						return true;
					}
				}
				
			}
			transaction.commit();
			
			return false;
		}
	 /**
	 * @param sID student Id
	 * @return Student information
	 */
	public static Student Retrieve(final String sID) {
			
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from Student");	    
			List<Student> stud = query.list();
			
			List<String> list = new ArrayList<String>();
			if(stud!=null&&stud.size()>0){
				for (int i = 0; i < stud.size(); i++) {
					if(stud.get(i).getStudentId().equals(sID)){
						return stud.get(i);
					}
				}
				
			}
			transaction.commit();
			
			
			// TODO Auto-generated method stub
			return null;
		}
	 
	 /**
	 * @return the list of all the students
	 * in the database
	 */
	public static List<Student> List_students(){
					
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from Student");	    
			List<Student> stud = query.list();
			transaction.commit();
					
			return stud;
		}
	 public static void main(String[] args) {
		 
		 Student s=new Student("studentiddd", "name", "major", "country");
		 System.out.println(List_students());
		 SaveForm(s);
		 System.out.println("catch!!!");
	 }
	 /**
	 * 
	 */
	public SetupDB(){}
}
