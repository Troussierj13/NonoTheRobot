package NonoTheRobot

class Vector2Test extends GroovyTestCase {
    void testEquals() {
        Vector2<Integer> v1 = new Vector2<>(1,11)
        Vector2<Integer> v2 = new Vector2<>(2, 12)
        Vector2<Integer> v3 = new Vector2<>(1, 13)
        Vector2<Integer> v4 = new Vector2<>(1, 11)
        assert !v1.equals(v2)
        assert !v1.equals(v3)
        assert v1.equals(v4)
    }

    void testToString() {
        Vector2<Integer> v = new Vector2<>(1, 11)
        assert v.toString() == "[1, 11]"
        v.x = -2
        assert v.toString() == "[-2, 11]"
    }
}
