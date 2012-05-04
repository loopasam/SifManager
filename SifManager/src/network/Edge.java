/**
 * 
 */
package network;

import java.util.HashMap;

/**
 * @author Samuel Croset
 *
 */
public class Edge {

    private HashMap<String, Attribute> attributes;

    void setAttributes(HashMap<String, Attribute> attributes) {
	this.attributes = attributes;
    }

    public HashMap<String, Attribute> getAttributes() {
	return attributes;
    }


    public Edge() {
	this.setAttributes(new HashMap<String, Attribute>());
    }


    public void addAttribute(Attribute attribute) {
	this.getAttributes().put(attribute.getHeader(), attribute);
    }

    /**
     * @param identifierEdges
     * @return
     */
    public Attribute getAttribute(String identifierEdges) {
	if(this.getAttributes().get(identifierEdges) != null){
	    return this.getAttributes().get(identifierEdges);
	}
	return null;
    }

    /**
     * @param identifierNodes
     * @return
     */
    public String getAttributeValue(String header) {

	if(this.getAttributes().get(header) == null){
	    try {
		throw new AttributeException("The edge " + this.toString() + " has no value for the attribute \"" + header + "\". Make sure all your nodes have a value for this attribute.");
	    } catch (AttributeException e) {
		e.printStackTrace();
	    }
	}else{
	    return this.getAttributes().get(header).getValue().toString();
	}
	return null;
    }

    /**
     * @param identifierEdges
     * @return
     */
    public String getCleanedAttributeValue(String header) {

	if(this.getAttributes().get(header) == null){
	    try {
		throw new AttributeException("The edge " + this.toString() + " has no value for the attribute \"" + header + "\". Make sure all your nodes have a value for this attribute.");
	    } catch (AttributeException e) {
		e.printStackTrace();
	    }
	}else{
	    return this.getAttributes().get(header).getValue().toString().replaceAll(" ", "_").replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("=", "_");
	}
	return null;
    }


}
