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
     * @param path
     * @param fileName
     * @param networkFile
     * @param string
     * @throws IOException 
     */
    private void writeFile(String path, String fileName, StringBuilder stringBuilder, String extension) throws IOException {
	FileWriter fstream = null;
	fstream = new FileWriter(path + "/" + fileName + "." + extension);
	BufferedWriter out = new BufferedWriter(fstream);
	out.write(stringBuilder.toString());
	out.close();
    }




    /**
     * @param string
     * @return
     */
    public StringAttributeFactory getNewStringAttributeFactory(String header) {

	if(this.mapAttributes.containsKey(header)){
	    try {
		throw new AttributeException("The attribute \"" + header + "\" is already in use. Try a different attribute header.");
	    } catch (AttributeException e) {
		e.printStackTrace();
	    }
	}else{
	    StringAttributeFactory stringAttributeFactory = new StringAttributeFactory(header);
	    this.mapAttributes.put(header, stringAttributeFactory);
	    return stringAttributeFactory;
	}
	return null;
    }


    /**
     * @param fileName 
     * @param path 
     * @throws IOException 
     * 
     */
    
    //TODO implementing a system based around the IDs rather than attributes
    public void saveAll(String path, String fileName) throws IOException {

	StringBuilder sifFile = new StringBuilder();
	for (Relation relation : this.getRelations()) {
	    String subjectString = relation.getSubject().getCleanedAttributeValue(this.getIdentifierNodes());
	    String edgeString = relation.getEdge().getCleanedAttributeValue(this.getIdentifierEdges());
	    String objectString = relation.getObject().getCleanedAttributeValue(this.getIdentifierNodes());

	    sifFile.append(subjectString + " " + edgeString + " " + objectString + "\n");

	}

	writeFile(path, fileName, sifFile, "sif"); 


	for (String header : this.getMapAttributes().keySet()) {

	    StringBuilder attributeFile = new StringBuilder();
	    attributeFile.append(header + " " + this.getMapAttributes().get(header).getAttributeTypeInString() + "\n");
	    ArrayList<String> visited = new ArrayList<String>();
	    String extension = null;

	    for (Relation relation : this.getRelations()) {

		if(relation.getSubject().getAttribute(header) != null){
		    String subjectValue = relation.getSubject().getAttributeValue(header);
		    String subjectString = relation.getSubject().getCleanedAttributeValue(this.getIdentifierNodes());
		    if(!visited.contains(subjectString)){
			attributeFile.append(subjectString + " = \"" + subjectValue + "\"\n");
			visited.add(subjectString);
			extension = "na";
		    }
		}

		if(relation.getObject().getAttribute(header) != null){
		    String objectValue = relation.getObject().getAttributeValue(header);
		    String objectString = relation.getObject().getCleanedAttributeValue(this.getIdentifierNodes());
		    if(!visited.contains(objectString)){
			attributeFile.append(objectString + " = \"" + objectValue + "\"\n");
			visited.add(objectString);
		    }
		}

		if(relation.getEdge().getAttribute(header) != null){
		    String subjectString = relation.getSubject().getCleanedAttributeValue(this.getIdentifierNodes());
		    String objectString = relation.getObject().getCleanedAttributeValue(this.getIdentifierNodes());
		    String edgeString = relation.getEdge().getCleanedAttributeValue(this.getIdentifierEdges());
		    String edgeValue = relation.getEdge().getAttribute(header).getValue().toString();
		    attributeFile.append(subjectString + " (" + edgeString + ") " + objectString + " = " + edgeValue + "\n");
		    extension = "ea";
		}
	    }

	    writeFile(path, fileName + "_" + header, attributeFile, extension);
	}
    }

    /**
     * @param string
     * @return
     */
    public IntegerAttributeFactory getNewIntegerAttributeFactory(String header) {

	if(this.mapAttributes.containsKey(header)){
	    try {
		throw new AttributeException("The attribute \"" + header + "\" is already in use. Try a different attribute header.");
	    } catch (AttributeException e) {
		e.printStackTrace();
	    }
	}else{
	    IntegerAttributeFactory stringAttributeFactory = new IntegerAttributeFactory(header);
	    this.mapAttributes.put(header, stringAttributeFactory);
	    return stringAttributeFactory;
	}
	return null;
    }



}
