package application.rest;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;

import application.Error_Response.BadRequestException;
import application.Error_Response.ConflictException;
import application.Utility.Json_Parser;
import application.business.SetupDB;
import application.model.Student;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;


/**
 * @author Thierry Edson Noumessi
 * 
 * This is a Restful Web services that allows clients to 
 * register, update, delete or extract students information
 * 
 */

@Path("/")
public class RestService {
	public static String ListStudents=Json_Parser.Object_to_Json(SetupDB.List_students());
	/**
	 * @param information about the request
	 * @return list of students registered
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object list( @Context Request req){
		System.out.println("before:"+ListStudents);		
		return ListStudents;
	}	
	
	
	/**
	 * @return the version of the Web Services
	 */
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnversion(){
		
		return "584215";
	}
	
	
	
	/**
	 * This method is used to save student information in the database.
	 * 
	 * @param studentId
	 * @param name
	 * @param major
	 * @param country
	 * @param uriInfo
	 * @return  It returns 3 possible solutions
	 * 
	 * Processes Form data from HTML
	 * Returns JSON data
	 * 
	 *         Code  200 if the operation is successful
	 *         Code  409 if the Student Id exists already
	 *         Code  400 if the data sent to the server are invalid 
	 */
	@Path("students")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Object saveStudent_Appform(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country,@Context UriInfo uriInfo){
		Student s=new Student(studentId, name, major, country);
		/*
		 *Server side validation. If an attacker circumvents the client side validation,
		 *the server will detect it and reject the data by throwing Code400 
		 * 
		 * This same Regex pattern utilized on the client side.
		 */
		 String expr_id="^([G]{1})([0-9]{6})$";
		 String expr_name="^([a-zA-Z]{2,20})$";
		 String expr_major="^([a-zA-Z]{3})$";
		 String expr_country="^([A-Z]{2,4})$";
		 List<String> errors=new ArrayList<String>();
		 CharSequence inputStr1 = studentId.trim();
		 CharSequence inputStr2 = name.trim();
		 CharSequence inputStr3 = major.trim();
		 CharSequence inputStr4 =country.trim();
		 Pattern pattern1 = Pattern.compile(expr_id,Pattern.CASE_INSENSITIVE);
		 Matcher matcher1 = pattern1.matcher(inputStr1);
		 Pattern pattern2 = Pattern.compile(expr_name,Pattern.CASE_INSENSITIVE);
		 Matcher matcher2 = pattern2.matcher(inputStr2);
		 Pattern pattern3 = Pattern.compile(expr_major,Pattern.CASE_INSENSITIVE);
		 Matcher matcher3 = pattern3.matcher(inputStr3);
		 Pattern pattern4 = Pattern.compile(expr_country,Pattern.CASE_INSENSITIVE);
		 Matcher matcher4 = pattern4.matcher(inputStr4);

			System.out.println(studentId+matcher1.matches());
			System.out.println(name+matcher2.matches());
			System.out.println(major+matcher3.matches());
			System.out.println(country+matcher4.matches());
		 if(!matcher1.matches()) errors.add("the Student Id format is invalid");
		 if(!matcher2.matches()) errors.add("the Student Name format is invalid");
		 if(!matcher3.matches()) errors.add("the Student Major format is invalid");
		 if(!matcher4.matches()) errors.add("the Student Country format is invalid");
		 if(matcher1.matches()&&matcher2.matches()&&matcher3.matches()&&matcher4.matches())
		 {
		 
		 if(!SetupDB.IdInuse(studentId)){
		SetupDB.SaveForm(s);
		System.out.println("Appform save");
		System.out.println(s);
		ListStudents =Json_Parser.Object_to_Json(SetupDB.List_students());
		return Json_Parser.Object_to_Json(SetupDB.Retrieve(studentId));
		
		}else{
			errors.add("This Student Id is already been used! pick a different one");
		//return	Response.status(Status.CONFLICT).type(MediaType.APPLICATION_JSON).entity(Json_Parser.Object_to_Json(errors)).build();	
			return ConflictException.toResponse(errors);
		}
		}
		System.out.println("cannot save");
		//throw new ConflictException(uriInfo.getBaseUriBuilder().path("/student/{studentId}").build(studentId));
		return BadRequestException.toResponse(errors);
	}
	/**
	 * @param studentId
	 * @param name
	 * @param major
	 * @param country
	 * 
	 * Same as saveStudent_Appform but consumes JSON data
	 */
	@Path("students")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveStudent_Json(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country){
		Student s=new Student(studentId, name, major, country);
		System.out.println("Json save");
		System.out.println(studentId);
		
		
	}
	
}
