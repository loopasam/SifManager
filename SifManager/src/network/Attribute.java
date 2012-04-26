/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public class Attribute<T>{

    private String header;
    private T value;
    private String typeString;
    
    
    public Attribute(String header) {
	this.header = header;
    }

    public void setHeader(String header) {
	this.header = header;
    }

    public String getHeader() {
	return header;
    }

    public void setTypeString(String typeString) {
	this.typeString = typeString;
    }

    public String getTypeString() {
	return typeString;
    }

    public void setValue(T value) {
	this.value = value;
	this.setTypeString(value.getClass().toString());
    }

    public T getValue() {
	return value;
    }
    

}
