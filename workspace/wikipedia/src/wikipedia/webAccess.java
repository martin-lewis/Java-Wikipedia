package wikipedia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class webAccess {
	
	public String rawJSON (String url) {
		try {
			URL page = new URL(url); //Forms the URL class
			URLConnection pageConnection = page.openConnection(); //Creates a connection to the webpage
			BufferedReader pageRead = new BufferedReader(new InputStreamReader(pageConnection.getInputStream())); //Forms a buffer which can be read from
			String returnVal = "";
			String currentLine;
			
			while ((currentLine = pageRead.readLine()) != null) { //Reads from the buffer until it runs out
				returnVal = returnVal + "\n" + currentLine; //Forms it into one String, line breaks are needed
			}
			return returnVal;
			
		} catch (Exception e) { //Catches any errors
			System.out.println("Error: " + e.toString()); //Reports errors
			return null;
		}
			
	}

}
