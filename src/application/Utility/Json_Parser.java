/**
 * 
 */
package application.Utility;

import application.business.SetupDB;

import com.google.gson.Gson;

/**
 * @author root
 * this is used to pasrse toString object to Json
 *
 */
public class Json_Parser {

	public Json_Parser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param Object
	 * @return Json representation of the object
	 */
	public static String Object_to_Json(Object ob){
		Gson gson = new Gson();
		String json = gson.toJson(ob);
		System.out.println(json);
	return json;
	}

}
