/**
 * 
 */
package application.Error_Response;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import application.Utility.Json_Parser;

/**
 * @author root
 *
 */
public class BadRequestException extends WebApplicationException {
	private static final long serialVersionUID = 1L;
    private List<String> errors;
    public BadRequestException(List<String> errors)
    {
        super(Response.status(Status.BAD_REQUEST).entity(new GenericEntity<List<String>>(errors){}).build());
        this.errors = errors;
    }
 
    public List<String> getErrors()
    {
        return errors;
    }
     public static Response toResponse(List<String> errors){
        	return Response.status(Status.BAD_REQUEST).entity(Json_Parser.Object_to_Json(errors)).build();		
    }

}
