/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public abstract class AttributeFactory {
    
    private String header;

    public void setHeader(String header) {
	this.header = header;
    }

    public String getHeader() {
	return header;
    }

    /**
     * @return
     */
    public abstract String getAttributeTypeInString();

}
