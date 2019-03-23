package wikipedia;
//Class which is in charge of accessing the API, this formats the calls and passes them to the 
public class APIAccess {
	
	public String basic (String name) { //Returns a basic request in terms of json
		String request = "https://en.wikipedia.org/w/api.php?action=query&prop=info&titles=" + name + "&format=json"; //Formats request
		webAccess web = new webAccess(); //Creates class
		String json = web.rawJSON(request); //Sends request
		if (json.equals(null)) { //If there has been an issue
			return null; //Return null up the chain
		} else { //If all is good
			return json; //Returns the json
		}
	}

}
