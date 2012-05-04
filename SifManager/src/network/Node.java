/**
 * 
 */
package network;

import java.util.HashMap;


/**
 * @author Samuel Croset
 *
 */
public class Node {

    private HashMap<String, Attribute> attributes;

    void setAttributes(HashMap<String, Attribute> attributes) {
	this.attributes = attributes;
    }

    public HashMap<String, Attribute> getAttributes() {
	return attributes;
    }


    public Node() {
	this.setAttributes(new HashMap<String, Attribute>());
    }


    public void addAttribute(Attribute attribute) {
	this.getAttributes().put(attribute.getHeader(), attribute);
    }

    /**
     * @param identifierNodes
     * @return
     */
    public Attribute getAttribute(String identifierNodes) {
	if(this.getAttributes().get(identifierNodes) != null){
	    return this.getAttributes().get(identifierNodes);
	}
	return null;
    }

    /**
     * @param header 
     * @return
     */
    public String getAttributeValue(String header) {

	if(this.getAttributes().get(header) == null){
	    try {
		throw new AttributeException("The node " + this.toString() + " has no value for the attribute \"" + header + "\". Make sure all your nodes have a value for this attribute.");
	    } catch (AttributeException e) {
		e.printStackTrace();
	    }
	}else{
	    return this.getAttributes().get(header).getValue().toString();
	}
	return null;
    }

    /**
     * @param identifierNodes
     * @return
     */
    public String getCleanedAttributeValue(String header) {

	if(this.getAttributes().get(header) == null){
	    try {
		throw new AttributeException("The node " + this.toString() + " has no value for the attribute \"" + header + "\". Make sure all your nodes have a value for this attribute.");
	    } catch (AttributeException e) {
		e.printStackTrace();
	    }
	}else{
	    return this.getAttributes().get(header).getValue().toString().replaceAll(" ", "_").replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("=", "_");
	}
	return null;
    }

}
