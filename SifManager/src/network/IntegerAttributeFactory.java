/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public class IntegerAttributeFactory extends AttributeFactory {
    

    public IntegerAttributeFactory(String header) {
	this.setHeader(header);
    }

    public Attribute getNewAttribute(Integer value) {

	IntegerAttribute attribute = new IntegerAttribute(this.getHeader());
	attribute.setValue(value); 
	return attribute;
    }

    /* (non-Javadoc)
     * @see network.AttributeFactory#getAttributeTypeInString()
     */
    @Override
    public String getAttributeTypeInString() {
	return "(class=java.lang.Integer)";
    }

}
