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

    public Attribute(String header) {
	this.header = header;
    }

    public void setHeader(String header) {
	this.header = header;
    }

    public String getHeader() {
	return header;
    }

    public void setValue(T value) {
	this.value = value;
    }

    public T getValue() {
	return value;
    }


}
