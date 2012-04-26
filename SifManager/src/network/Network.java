/**
 * 
 */
package network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Network {

    private ArrayList<Relation> relations;
    private Attribute<?> nodesLabel;
    private Attribute<?> edgesLabel;
    private ArrayList<Attribute<?>> attributes;


    public void setAttributes(ArrayList<Attribute<?>> attributes) {
	this.attributes = attributes;
    }

    public ArrayList<Attribute<?>> getAttributes() {
	return attributes;
    }

    public void setEdgesLabel(Attribute<?> edgesLabel) {
	this.edgesLabel = edgesLabel;
    }

    public Attribute<?> getEdgesLabel() {
	return edgesLabel;
    }

    public void setNodesLabel(Attribute<?> nodesLabel) {
	this.nodesLabel = nodesLabel;
    }

    public Attribute<?> getNodesLabel() {
	return nodesLabel;
    }

    public Network() {
	this.relations = new ArrayList<Relation>();
	this.attributes = new ArrayList<Attribute<?>>();
    }

    public void setRelations(ArrayList<Relation> relations) {
	this.relations = relations;
    }

    public ArrayList<Relation> getRelations() {
	return relations;
    }

    /**
     * @param relation
     */
    public void addRelation(Relation relation) {
	this.relations.add(relation);
    }

    /**
     * @param attribute
     */
    public void save(String path, String fileName) {
	StringBuilder networkFile = new StringBuilder();
	for (Relation relation : this.relations) {
	    if(this.nodesLabel == null || this.edgesLabel == null){
		System.err.println("no identifier defined!");
	    }else{
		String subjectString = relation.getSubject().getAttributeValue(this.nodesLabel);		
		String edgeString = relation.getEdge().getAttributeValue(this.edgesLabel);
		String objectString = relation.getObject().getAttributeValue(this.nodesLabel);
		networkFile.append(subjectString + " " + edgeString + " " + objectString + "\n");
	    }
	}
	
	writeFile(path, fileName, networkFile, "sif");

	for (Attribute<?> attribute : this.getAttributes()) {
	    ArrayList<String> visitedNode = new ArrayList<String>();
	    System.out.println(attribute.getHeader());
	    
	    for (Relation relation : this.getRelations()) {

		Node subject = relation.getSubject();
		String subjectString = relation.getSubject().getAttributeValue(this.nodesLabel);		
		if(subject.getAttributeValue(attribute) != null 
			&& !visitedNode.contains(subjectString)){
		    
		    System.out.println("type: " + subject.getAttributeType(attribute));
		    System.out.println(subjectString + " = " + subject.getAttributeValue(attribute));
		    visitedNode.add(subjectString);
		}

		Node object = relation.getObject();
		String objectString = relation.getObject().getAttributeValue(this.nodesLabel);		
		if(object.getAttributeValue(attribute) != null 
			&& !visitedNode.contains(objectString)){
		    System.out.println(objectString + " = " + object.getAttributeValue(attribute));
		    visitedNode.add(objectString);
		}

		Edge edge = relation.getEdge();
		String edgeString = relation.getEdge().getAttributeValue(this.edgesLabel);
		if(edge.getAttributeValue(attribute) != null){

		    String subjectStringEdge = relation.getSubject().getAttributeValue(this.nodesLabel);		
		    String objectStringEdge = relation.getObject().getAttributeValue(this.nodesLabel);		

		    System.out.println(subjectStringEdge + " "
			    + edgeString + " " + objectStringEdge +" = " 
			    + edge.getAttributeValue(attribute));
		}
	    }
	}

    }

    /**
     * @param path
     * @param fileName
     * @param networkFile
     * @param string
     */
    private void writeFile(String path, String fileName, StringBuilder stringBuilder, String extension) {
	FileWriter fstream = null;
	try {
	    fstream = new FileWriter(path + "/" + fileName + "." + extension);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	BufferedWriter out = new BufferedWriter(fstream);
	try {
	    out.write(stringBuilder.toString());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	try {
	    out.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}	
    }

    /**
     * @param <T>
     * @param attribute
     */
    public <T> void setNodeLabel(Attribute<T> attribute) {
	this.setNodesLabel(attribute);
    }

    /**
     * @param <T>
     * @param typeEdge
     */
    public <T> void setEdgeLabel(Attribute<T> attribute) {
	this.setEdgesLabel(attribute);
    }

    /**
     * @param <T>
     * @param string
     * @return
     */
    public <T> Attribute<T> getNewAttribute(String header) {
	// TODO check uniqueness of name
	Attribute<T> attribute = new Attribute<T>(header);
	this.getAttributes().add(attribute);
	return attribute;
    }


}
