/**
 * 
 */
package examples;


import network.Attribute;
import network.Edge;
import network.Network;
import network.Node;
import network.Relation;
import network.StringAttributeFactory;

/**
 * @author Samuel Croset
 *
 */
public class Example1 {

    public static void main(String[] args) {

	Network network = new Network();

	StringAttributeFactory countryFactory = network.getNewStringAttributeFactory("country");
	StringAttributeFactory relationTypeFactory = network.getNewStringAttributeFactory("relationType");
	StringAttributeFactory nameFactory = network.getNewStringAttributeFactory("name");
	
	
	network.setIdentifierNodes("country");
	network.setIdentifierEdges("relationType");

	Attribute franceAttribute = countryFactory.getNewAttribute("France");
	Node node1 = new Node();
	node1.addAttribute(franceAttribute);
	Attribute pierreattribute = nameFactory.getNewAttribute("Pierre");
	node1.addAttribute(pierreattribute);

	Node node2 = new Node();
	Attribute germanyAttribute = countryFactory.getNewAttribute("Germany");
	node2.addAttribute(germanyAttribute);
	Attribute paulAttribute = nameFactory.getNewAttribute("Paul");
	node2.addAttribute(paulAttribute);

	Edge edge1 = new Edge();
	Attribute nextAttribute = relationTypeFactory.getNewAttribute("next_to");
	edge1.addAttribute(nextAttribute);
	
	Relation relation = new Relation(node1, edge1, node2);
	
	network.addRelation(relation);
	
	network.saveAll();


//	network.save("dev_data", "demo");

    }

}
