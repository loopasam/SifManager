/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public class StringAttribute extends Attribute{
    
    
    private String value;

    /**
     * @param header
     */
    public StringAttribute(String header) {
	this.setHeader(header);
    }

    /* (non-Javadoc)
     * @see network.Attribute#setValue(java.lang.Object)
     */
    @Override
    public void setValue(Object value) {
	this.value = (String) value;
    }

    /* (non-Javadoc)
     * @see network.Attribute#getValue()
     */
    @Override
    public Object getValue() {
	return this.value;
    }


}
