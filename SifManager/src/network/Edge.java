/**
 * 
 */
package network;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Edge {
    
    private ArrayList<Attribute<? extends Object>> attributes;
    
    public Edge() {
	this.attributes = new ArrayList<Attribute<? extends Object>>();
    }

    public <T> void addAttributeValue(Attribute<T> stringAttribute, T value) {
	Attribute<T> newAttribute = new Attribute<T>(stringAttribute.getHeader());
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
