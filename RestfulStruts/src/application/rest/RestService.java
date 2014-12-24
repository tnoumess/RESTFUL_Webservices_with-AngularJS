/**
 * 
 */
package application.rest;


import javax.ws.rs.Consumes;

import application.business.SetupDB;
import application.model.Student;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author root
 *
 */
@Path("/")
public class RestService {
	public static String users="[{\"studentId\": \"G00760357\",\"name\": \"Noumessi\"},{\"studentId\": \"G00760358\",\"name\": \"Tawo\" }]"; 
	
	public static String user="[{studentId: \"G00760357\",name: \"Noumessi\"},{studentId: \"G00760358\",name: \"Tawo\" }]"; 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returntitle(){
		System.out.println("inside");
		return users;
	}
	
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnversion(){
		
		return "584215";
	}
	
	@Path("students")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void saveStudent_Appform(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country){
		Student s=new Student(studentId, name, major, country);
		System.out.println("Appform save");
		System.out.println(studentId);
		
	}
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveStudent_Json(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country){
		Student s=new Student(studentId, name, major, country);
		System.out.println("Json save");
		System.out.println(studentId);
		
	}
}
