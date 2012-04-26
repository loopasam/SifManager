/**
 * 
 */
package examples;

import java.util.ArrayList;

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
	Attribute<String> nameAttribute = network.getNewAttribute("name");
	Attribute<String> countryAttribute = network.getNewAttribute("country");
	Attribute<Integer> ageAttribute = network.getNewAttribute("age");
	
	Attribute<Integer> weightAttribute = network.getNewAttribute("weight");
	Attribute<String> typeEdge = network.getNewAttribute("type");	

	Node node1 = new Node();
	node1.addAttributeValue(nameAttribute, "Pierre");
	node1.addAttributeValue(countryAttribute	, "france");
	node1.addAttributeValue(ageAttribute, 25);

	Node node2 = new Node();
	node2.addAttributeValue(nameAttribute, "Paul");
	node2.addAttributeValue(countryAttribute, "spain");
	node2.addAttributeValue(ageAttribute, 35);

	Edge edge1 = new Edge();
	edge1.addAttributeValue(weightAttribute, 3);
	edge1.addAttributeValue(typeEdge, "friend");

	Relation relation = new Relation(node1, edge1, node2);
	network.addRelation(relation);
	
	
	Node node4 = new Node();
	node4.addAttributeValue(nameAttribute, "Marie");
	node4.addAttributeValue(countryAttribute, "russia");
	node4.addAttributeValue(ageAttribute, 27);

	Edge edge2 = new Edge();
	edge2.addAttributeValue(weightAttribute, 12);
	edge2.addAttributeValue(typeEdge, "love");

	Relation relation2 = new Relation(node1, edge2, node4);
	network.addRelation(relation2);

	
	network.setNodeLabel(nameAttribute);
	network.setEdgeLabel(typeEdge);
	network.save("dev_data", "demo");

    }

}
