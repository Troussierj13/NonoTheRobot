package NonoTheRobot

class NodeTest extends GroovyTestCase {
    void testGeneral() {
        Node<Integer> node1 = new Node<>(1, null)
        Node<Integer> node2 = new Node<>(2, node1)

        assert node2.value == 2
        assert node2.parent == node1
        assert node2.parent.value == 1
    }
}
