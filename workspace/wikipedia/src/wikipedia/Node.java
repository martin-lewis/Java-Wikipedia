package wikipedia;

import java.util.ArrayList;

//This is the class which represents a single article/page within Wikipedia
public class Node {
	
	private String name; //Contains the name of the article, this is the version used to access the article
	private ArrayList<Node> outgoingLinks; //Contains all the nodes which this article point to
	private ArrayList<Node> incomingLinks; //Contains all the nodes which point to this article
	
	public Node (String name1) { //Initialises the Node
		//Must add validation to ensure that an article of that name exists
		name = name1;
		outgoingLinks = new ArrayList<Node>();
		incomingLinks = new ArrayList<Node>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addOutgoingLink(Node out) {
		outgoingLinks.add(out);
	}
	
	public void addincomingLink(Node in) {
		incomingLinks.add(in);
	}
	
	public ArrayList<Node> getOutgoingLinks() {
		return outgoingLinks;
	}
	
	public ArrayList<Node> getIncomingLinks() {
		return incomingLinks;
	}

}
