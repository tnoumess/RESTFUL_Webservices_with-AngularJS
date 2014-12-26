/**
 * 
 */
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
 * @author root
 *
 */
@Path("/")
public class RestService {
	public static String users="[{\"studentId\": \"G00760357\",\"name\": \"Noumessi\"},{\"studentId\": \"G00760358\",\"name\": \"Tawo\" }]"; 
	public static String ListStudents=Json_Parser.Object_to_Json(SetupDB.List_students());
	public static String user="[{studentId: \"G00760357\",name: \"Noumessi\"},{studentId: \"G00760358\",name: \"Tawo\" }]"; 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returntitle( @Context Request req){
		/*CacheControl cc = new CacheControl();
        //Set max age to one day
        cc.setMaxAge(86400);
        Response.ResponseBuilder rb = null;
        
        EntityTag etag = new EntityTag(users.hashCode()+"");
        
        //Verify if it matched with etag available in http request
        rb = req.evaluatePreconditions(etag);
         
        //If ETag matches the rb will be non-null;
        //Use the rb to return the response without any further processing
        if (rb == null)
        {
            return rb.cacheControl(cc).tag(etag).build();
        }
         
        //If rb is null then either it is first time request; or resource is modified
        //Get the updated representation and return with Etag attached to it
        rb = Response.ok(users).cacheControl(cc).tag(etag);*/
		System.out.println("inside");
		System.out.println(req.toString());
	
		//return rb.build();
	/*	if(1!=1) {
			throw new WebApplicationException(Response.status(
					Response.Status.UNAUTHORIZED).type(
					MediaType.APPLICATION_JSON).entity(
					"Book, " +"edson"+ ", is not found").build());
		}*/
		System.out.println("before:"+ListStudents);
		
		//if(ListStudents==null)
		//ListStudents =Json_Parser.Object_to_Json(SetupDB.List_students());
		//System.out.println("after"+ListStudents);
	return ListStudents;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Object saveStudent_Appform(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country,@Context UriInfo uriInfo){
		Student s=new Student(studentId, name, major, country);
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
			 throw new ConflictException(uriInfo.getBaseUriBuilder().path("/users/{username}").build(studentId));
			 
			//return ConflictException.toResponse("The Student Id");
		}
		}
		System.out.println("cannot save");
		//throw new ConflictException(uriInfo.getBaseUriBuilder().path("/student/{studentId}").build(studentId));
		return BadRequestException.toResponse(errors);
	}
	@Path("students")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveStudent_Json(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country){
		Student s=new Student(studentId, name, major, country);
		System.out.println("Json save");
		System.out.println(studentId);
		
		
	}
	
}
