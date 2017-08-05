package cs143;

/**
 * This class represents a generic node in a doubly linked list.
 * 
 * @author Linda Zuvich
 */
public class Node<E> {
    
    //fields
    private Node prev;
    private Node next;
    private E value;
    
    /**
     * Constructor that sets prev and next to null.
     * 
     * @param value the value to enter in this node
     */
    public Node(E value) {
        this.value = value;
    }
    
    /**
     * Full constructor.
     * 
     * @param value the value to enter in this node
     * @param prev the node just before this one
     * @param next the node just after this one
     */
    public Node(E value, Node prev, Node next) {
        this(value);
        this.prev = prev;
        this.next = next;
    }

    /**
     * Provides access to the previous node.
     * 
     * @return the previous node
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * Allows the previous node to be set.
     * 
     * @param prev the previous node 
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Provides access to the next node.
     * 
     * @return the next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Allows the next node to be set.
     * 
     * @param next the next node
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Provides access to the value stored in this node
     * 
     * @return the value
     */
    public E getValue() {
        return value;
    }

    /**
     * Allows the value stored in this node to be set.
     * 
     * @param value the value
     */
    public void setValue(E value) {
        this.value = value;
    }
    
}
