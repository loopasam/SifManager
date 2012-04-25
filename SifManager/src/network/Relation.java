/**
 * 
 */
package network;

/**
 * @author Samuel Croset
 *
 */
public class Relation {
    
    private Node subject;
    private Edge edge;
    private Node object;
    
    public Node getSubject() {
        return subject;
    }
    public void setSubject(Node subject) {
        this.subject = subject;
    }
    public Edge getEdge() {
        return edge;
    }
    public void setEdge(Edge edge) {
        this.edge = edge;
    }
    public Node getObject() {
        return object;
    }
    public void setObject(Node object) {
        this.object = object;
    }
    
}
