/**
 * 
 */
package examples;


import java.io.IOException;

import network.Attribute;
import network.Edge;
import network.IntegerAttributeFactory;
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
	
	StringAttributeFactory typeFactory = network.getNewStringAttributeFactory("type");
	StringAttributeFactory nameFactory = network.getNewStringAttributeFactory("name");
	StringAttributeFactory relationTypeFactory = network.getNewStringAttributeFactory("relationStrength");
	IntegerAttributeFactory relationWeightFactory = network.getNewIntegerAttributeFactory("weight");
	
	
	network.setIdentifierNodes("name");
	network.setIdentifierEdges("relationStrength");
	
	Attribute drugType = typeFactory.getNewAttribute("Drug");
	Attribute diseaseType = typeFactory.getNewAttribute("Disease");
	
	Node drugA = new Node();
	Attribute drugAname = nameFactory.getNewAttribute("sildenafil");
	drugA.addAttribute(drugAname);
	drugA.addAttribute(drugType);
	
	Node diseaseA = new Node();
	Attribute diseaseName = nameFactory.getNewAttribute("cancer");
	diseaseA.addAttribute(diseaseName);
	diseaseA.addAttribute(diseaseType);
	
	Edge edgeA = new Edge();
	Attribute edgeAStrength = relationTypeFactory.getNewAttribute("weak action");
	Attribute edgeAWeight = relationWeightFactory.getNewAttribute(12);
	edgeA.addAttribute(edgeAStrength);
	edgeA.addAttribute(edgeAWeight);
	
	Relation relationA = new Relation(drugA, edgeA, diseaseA);
	network.addRelation(relationA);
	
	Node drugB = new Node();
	Attribute drugBname = nameFactory.getNewAttribute("sildenafil");
	drugB.addAttribute(drugBname);
	drugB.addAttribute(drugType);
	
	Node diseaseB = new Node();
	Attribute diseaseBName = nameFactory.getNewAttribute("erectile dysfuntion");
	diseaseB.addAttribute(diseaseBName);
	diseaseB.addAttribute(diseaseType);
	
	Edge edgeB = new Edge();
	Attribute edgeBStrength = relationTypeFactory.getNewAttribute("strong action");
	Attribute edgeBWeight = relationWeightFactory.getNewAttribute(25);
	edgeB.addAttribute(edgeBWeight);
	edgeB.addAttribute(edgeBStrength);
	
	Relation relationB = new Relation(drugB, edgeB, diseaseB);
	network.addRelation(relationB);

	try {
	    network.saveAll("dev_data", "demo");
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
