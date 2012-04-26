/**
 * 
 */
package network;

import java.util.ArrayList;


/**
 * @author Samuel Croset
 *
 */
public class Node {

    private ArrayList<Attribute<? extends Object>> attributes;

    public Node() {
	this.attributes = new ArrayList<Attribute<? extends Object>>();
    }

    public <T> void addAttributeValue(Attribute<T> attribute, T value) {
	Attribute<T> newAttribute = new Attribute<T>(attribute.getHeader());
	newAttribute.setValue(value);
	attributes.add(newAttribute);
    }

    public <T> String getAttributeValue(Attribute<T> attributeToFind){
	String attributeHeader = attributeToFind.getHeader();
	for (Attribute<? extends Object> attribute : this.attributes) {
	    if(attribute.getHeader().equals(attributeHeader)){
		return attribute.getValue().toString();
	    }
	}
	return null;
    }


}
