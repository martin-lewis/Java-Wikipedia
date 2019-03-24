package wikipedia;

import java.util.ArrayList;
import java.util.Arrays;

//Class in charge of ensuring the logic is sound. I.e. validation
public class wikiLogic {
	//The below array list contains a number of prefixes which are not valid for articles, these are meta pages within wikipedia
	private static final ArrayList<String> invalidTypes = new ArrayList<String>(Arrays.asList("Wikipedia:", "Help:", "Media:", "Template:"));
	
	public static boolean isValidPage(String name) { //Checks if the given name relates to a valid page
		for (String prefix : invalidTypes) { //For each invalid prefix
			if (name.startsWith(prefix)) { //If the name has that prefix
				return false; //Return false as it is invalid
			}
		}
		//Check it exists within the API
		
		return false; //While implementing
	}

}
