/**
 * 
 */
package network;

import java.util.ArrayList;
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


}
