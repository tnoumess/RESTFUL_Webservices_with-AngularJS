/**
 * 
 */
package application.Error_Response;

import java.net.URI;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import application.Utility.Json_Parser;

/**
 * @author root
 *
 */
public class ConflictException extends WebApplicationException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 303506880333038581L;

	public ConflictException()
    {
        this(null, null);
    } 
    public ConflictException(URI location)
    {
        this(location, null);
    }
 
    public ConflictException(URI location, Object entity)
    {
        super(Response.status(Status.CONFLICT).location(location).type(MediaType.APPLICATION_JSON).entity(entity).build());
    }
    public static Response toResponse(String errors){
    	return Response.status(Status.CONFLICT).type(MediaType.APPLICATION_JSON).entity(Json_Parser.Object_to_Json(errors)).build();		
}

}
