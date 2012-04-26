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

    public <T> void addAttributeValue(Attribute<T> stringAttribute, T value) {
	Attribute<T> newAttribute = new Attribute<T>(stringAttribute.getHeader());
	newAttribute.setValue(value);
	attributes.add(newAttribute);
    }



}
