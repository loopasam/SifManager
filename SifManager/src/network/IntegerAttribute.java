/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public class IntegerAttribute extends Attribute {
    
    
    private Integer value;

    /**
     * @param header
     */
    public IntegerAttribute(String header) {
	this.setHeader(header);
    }

    /* (non-Javadoc)
     * @see network.Attribute#setValue(java.lang.Object)
     */
    @Override
    public void setValue(Object value) {
	this.value = (Integer) value;
    }

    /* (non-Javadoc)
     * @see network.Attribute#getValue()
     */
    @Override
    public Object getValue() {
	return this.value;
    }


}
