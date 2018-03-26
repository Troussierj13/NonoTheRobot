public class Node<T> {
    public Node parent;
    public Vector2<T> vector;

    Node(T x,T y, Node parent){
        vector = new Vector2<T>(x, y);
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        Node<T> n = (Node<T>)o;
        return (vector.x == n.vector.x && vector.y == n.vector.y);
    }
}