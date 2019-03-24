package wikipedia;

import java.util.ArrayList;
import java.util.Arrays;

//This is the client class for testing and contains the main
public class Control {
	
	public static void main(String[] args) {
		//Testing Below
		String test = webAccess.rawJSON("https://en.wikipedia.org/w/api.php?action=query&prop=info&titles=Ball&format=json");
		JsonHandler test12 = new JsonHandler(test);
		//System.out.println(test12.getID());
		
		ArrayList<String> testArrayList = new ArrayList<String>(Arrays.asList("\"test\"", "test", "\"test", "test\""));
		ArrayList<String> tested = test12.quoteRemovers(testArrayList);
		for (String item: tested) {
			System.out.println(item);
		}
		
	}

}
