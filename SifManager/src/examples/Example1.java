/**
 * 
 */
package examples;

import network.Attribute;
import network.Edge;
import network.Network;
import network.Node;
import network.Relation;

/**
 * @author Samuel Croset
 *
 */
public class Example1 {
    
    public static void main(String[] args) {
	
	Network network = new Network();
	
	AttributeFactory factory = new AttributeFactory();
	Attribute nameAttribute = factory.getNewAttribute("name", "String");
	
	Node node1 = new Node();
	node1.setAttribute(nameAttribute, "Jean-Pierre");
	
	Node node2 = new Node();
	node2.setAttribute(nameAttribute, "Marie");
	
	Edge edge1 = new Edge();
	Attribute weightAttribute = factory.getNewAttribute("weight", "Integer");
	edge1.setAttribute(weightAttribute, 3);
	
	Relation relation = new Relation(node1, edge1, node2);
	
	network.addRelation(relation);
	
	network.mergeNodesFromAttribute(nameAttribute);
	
    }

}
