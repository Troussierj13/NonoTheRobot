package NonoTheRobot;

/**
 * TODO
 */
public class Node<T> {
    public Node parent;
    public T value;

    /**
     * TODO
     * @param value
     * @param parent
     */
    Node(T value, Node parent){
        this.value = value;
        this.parent = parent;
    }
}