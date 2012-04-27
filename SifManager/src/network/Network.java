/**
 * 
 */
package network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Samuel Croset
 *
 */
public class Network {

    private ArrayList<Relation> relations;
    private HashMap<String, AttributeFactory> mapAttributes;
    private String identifierNodes;
    private String identifierEdges;

    public HashMap<String, AttributeFactory> getMapAttributes() {
	return mapAttributes;
    }

    public void setMapAttributes(HashMap<String, AttributeFactory> mapAttributes) {
	this.mapAttributes = mapAttributes;
    }

    public void setIdentifierEdges(String identifierEdges) {
	if(this.getMapAttributes().containsKey(identifierNodes)){
	    this.identifierEdges = identifierEdges;
	}else{
	    System.err.println("identifier unknown");
	}
    }

    public String getIdentifierEdges() {
	return identifierEdges;
    }

    public void setIdentifierNodes(String identifierNodes) {
	if(this.getMapAttributes().containsKey(identifierNodes)){
	    this.identifierNodes = identifierNodes;
	}else{
	    System.err.println("identifier unknown");
	}
    }

    public String getIdentifierNodes() {
	return identifierNodes;
    }

    public Network() {
	this.setMapAttributes(new HashMap<String, AttributeFactory>());
	this.setRelations(new ArrayList<Relation>());
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
    //    public void save(String path, String fileName) {
    //	StringBuilder networkFile = new StringBuilder();
    //	for (Relation relation : this.relations) {
    //	    if(this.nodesLabel == null || this.edgesLabel == null){
    //		System.err.println("no identifier defined!");
    //	    }else{
    //		String subjectString = relation.getSubject().getAttributeValue(this.nodesLabel);		
    //		String edgeString = relation.getEdge().getAttributeValue(this.edgesLabel);
    //		String objectString = relation.getObject().getAttributeValue(this.nodesLabel);
    //		networkFile.append(subjectString + " " + edgeString + " " + objectString + "\n");
    //	    }
    //	}
    //
    //	writeFile(path, fileName, networkFile, "sif");
    //
    //	for (Attribute<?> attribute : this.getAttributes()) {
    //	    ArrayList<String> visitedNode = new ArrayList<String>();
    //	    System.out.println(attribute.getHeader());
    //
    //	    for (Relation relation : this.getRelations()) {
    //
    //		Node subject = relation.getSubject();
    //		String subjectString = relation.getSubject().getAttributeValue(this.nodesLabel);		
    //		if(subject.getAttributeValue(attribute) != null 
    //			&& !visitedNode.contains(subjectString)){
    //
    //		    //TODO utiliser ca pour print sur le fichier - finir creation de fichier
    //		    System.out.println("type: " + subject.getAttributeType(attribute));
    //		    System.out.println(subjectString + " = " + subject.getAttributeValue(attribute));
    //		    visitedNode.add(subjectString);
    //		}
    //
    //		Node object = relation.getObject();
    //		String objectString = relation.getObject().getAttributeValue(this.nodesLabel);		
    //		if(object.getAttributeValue(attribute) != null 
    //			&& !visitedNode.contains(objectString)){
    //		    System.out.println(objectString + " = " + object.getAttributeValue(attribute));
    //		    visitedNode.add(objectString);
    //		}
    //
    //		Edge edge = relation.getEdge();
    //		String edgeString = relation.getEdge().getAttributeValue(this.edgesLabel);
    //		if(edge.getAttributeValue(attribute) != null){
    //
    //		    String subjectStringEdge = relation.getSubject().getAttributeValue(this.nodesLabel);		
    //		    String objectStringEdge = relation.getObject().getAttributeValue(this.nodesLabel);		
    //
    //		    System.out.println(subjectStringEdge + " "
    //			    + edgeString + " " + objectStringEdge +" = " 
    //			    + edge.getAttributeValue(attribute));
    //		}
    //	    }
    //	}
    //
    //    }

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
     * @param string
     * @return
     */
    public StringAttributeFactory getNewStringAttributeFactory(String header) {

	if(this.mapAttributes.containsKey(header)){
	    System.err.println("header existing already");
	}else{
	    StringAttributeFactory stringAttributeFactory = new StringAttributeFactory(header);
	    this.mapAttributes.put(header, stringAttributeFactory);
	    return stringAttributeFactory;
	}
	return null;
    }


    /**
     * 
     */
    public void saveAll() {

	//Saving main file
	for (Relation relation : this.getRelations()) {

	    String subjectString = relation.getSubject().getAttribute(this.getIdentifierNodes()).getValue().toString();
	    String edgeString = relation.getEdge().getAttribute(this.getIdentifierEdges()).getValue().toString();
	    String objectString = relation.getObject().getAttribute(this.getIdentifierNodes()).getValue().toString();
	    System.out.println(subjectString + " " + edgeString + " " + objectString);

	}

	//Saving attributes files
	for (String header : this.getMapAttributes().keySet()) {

	    System.out.println(header + " - " + this.getMapAttributes().get(header).getClass());

	    for (Relation relation : this.getRelations()) {

		if(relation.getSubject().getAttribute(header) != null){
		    String subjectValue = relation.getSubject().getAttribute(header).getValue().toString();
		    System.out.println(subjectValue);
		}

		if(relation.getObject().getAttribute(header) != null){
		    String objectValue = relation.getObject().getAttribute(header).getValue().toString();
		    System.out.println(objectValue);
		}

		if(relation.getEdge().getAttribute(header) != null){
		    String edgeValue = relation.getEdge().getAttribute(header).getValue().toString();
		    System.out.println(edgeValue);
		}
	    }
	}


    }



}
