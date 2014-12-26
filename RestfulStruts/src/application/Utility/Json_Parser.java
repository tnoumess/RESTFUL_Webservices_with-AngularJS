/**
 * 
 */
package application.Utility;

import application.business.SetupDB;

import com.google.gson.Gson;

/**
 * @author root
 *
 */
public class Json_Parser {

	public Json_Parser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static String Object_to_Json(Object ob){
		Gson gson = new Gson();
		String json = gson.toJson(ob);
		System.out.println(json);
	return json;
	}

}
