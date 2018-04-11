package NonoTheRobot;

/**
 * Node with a value and a reference on another node
 */
public class Node<T> {
    public Node parent;
    public T value;

    /**
     * @param value Node value
     * @param parent another node for create link. Can be null.
     */
    Node(T value, Node parent){
        this.value = value;
        this.parent = parent;
    }
}