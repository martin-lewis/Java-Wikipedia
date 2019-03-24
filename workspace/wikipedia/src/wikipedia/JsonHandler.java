package wikipedia;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//This class deals with handling JSON
public class JsonHandler {
	
	public JSONArray arrayForm; //Temporary Public until interface is built
	
	public JsonHandler (String rawJson) { //Constructor
		JSONParser parse = new JSONParser(); //Creates parser
		try {
			JSONObject temp = (JSONObject) parse.parse(rawJson);
			JSONObject temp1 = (JSONObject) temp.get("query");
			JSONObject temp2 = (JSONObject) temp1.get("pages");
			JSONObject temp3 = (JSONObject) temp2.get(scrapeID(temp2.toJSONString())); //Above lines burrow down to the actual data
			arrayForm = new JSONArray();
			arrayForm.add(temp3);
		} catch (Exception e) { //If an error occurs
			System.out.println("JsonHandler Issue: " + e); //Print out
		}
		// Forming hashmap
		HashMap<String,String> stuff = new HashMap<>(); //Hash map is created
		String data = arrayForm.toJSONString(); //String form gained
		data = data.substring(2, data.length() - 2); //Removal of {}
		//System.out.println(data);
		String[] stuff1 = data.split(","); //Split all values
		ArrayList<String> keys = new ArrayList<>(); //Two arrays to hold keys and values
		ArrayList<String> values = new ArrayList<>();
		for (String item: stuff1) {
			String[] splitKeyVal = item.split(":");
			keys.add(splitKeyVal[0]);
			values.add(splitKeyVal[1]);
		}
		//Now send the two array lists via the quoteRemovers and then run a for loop and add them to the hashlist
	}
	
	private String scrapeID(String raw) {
		int val = raw.indexOf(':', 0);
		String id = raw.substring(2, val - 1);
		System.out.println(id);
		return id;
	}
	
	public ArrayList<String> quoteRemovers(ArrayList<String> original) { //Takes a arraylist of string and removes quotemarks from the front or back
		ArrayList<String> converted = new ArrayList<>(); //Creates new arraylist
		for (String item : original) { //Loops list
			String val = item; //Mistrusting of for loop
			if (val.charAt(0) == '"') { //If there a quotemark at the front
				val = val.substring(1); //Its removed
			}
			if (val.charAt(val.length() - 1) == '"') { //If theres a quote at the back
				val = val.substring(0, val.length()-1); //Its removed
			}
			converted.add(val); //The processed values is added to the new array list
		}
		return converted; //The converted array list is returned
	}
	
	public String getID () { //Some test function with out use while hashmap work continues
		Object[] ray = arrayForm.toArray();
		//System.out.println(arrayForm.contains()
		return ray[0].toString();
		
	}
	

}
