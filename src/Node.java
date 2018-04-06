public class Node<T> {
    public Node parent;
    public T value;

    Node(T value, Node parent){
        this.value = value;
        this.parent = parent;
    }
}