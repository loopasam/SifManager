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
		String subject = relation.getSubject().getAttributeValue(this.nodesLabel);
		String edge = relation.getEdge().getAttributeValue(this.edgesLabel);
		String object = relation.getObject().getAttributeValue(this.nodesLabel);
		networkFile.append(subject + " " + edge + " " + object + "\n");
	    }
	}
	writeFile(path, fileName, networkFile, "sif");

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


}
