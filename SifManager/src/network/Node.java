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

}
