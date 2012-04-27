/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public class StringAttributeFactory extends AttributeFactory {
    

    public StringAttributeFactory(String header) {
	this.setHeader(header);
    }

    public Attribute getNewAttribute(String value) {

	StringAttribute attribute = new StringAttribute(this.getHeader());
	attribute.setValue(value); 
	return attribute;
    }

}
