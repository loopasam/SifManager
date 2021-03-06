/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public abstract class Attribute {
    
    private String header;

    public void setHeader(String header) {
	this.header = header;
    }

    public String getHeader() {
	return header;
    }
    
    public abstract void setValue(Object value);
    
    public abstract Object getValue();

}
