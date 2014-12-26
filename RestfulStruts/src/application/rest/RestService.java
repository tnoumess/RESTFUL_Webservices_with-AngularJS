/**
 * 
 */
package application.rest;


import javax.ws.rs.Consumes;

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

import com.google.gson.Gson;


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
		
		//System.out.println(json);
	return Json_Parser.Object_to_Json(SetupDB.List_students());
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
	public String saveStudent_Appform(@FormParam("studentId") String studentId, @FormParam("name") String name, @FormParam("major")String major,@FormParam("country")String country){
		
		if(!SetupDB.IdInuse(studentId)){
		
		Student s=new Student(studentId, name, major, country);		
		
		System.out.println("Appform save");
		System.out.println(s);
		SetupDB.SaveForm(s);
		System.out.println("Appform save");
		System.out.println(s);
		return "";
		
		}
		return "";		
		
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
