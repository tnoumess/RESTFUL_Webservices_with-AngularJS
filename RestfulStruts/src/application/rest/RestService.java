/**
 * 
 */
package application.rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author root
 *
 */
@Path("/v1/status/")
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
}
