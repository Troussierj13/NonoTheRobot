package NonoTheRobot;

/**
 * Vector in two dimension type T
 */
public class Vector2<T>{
    T x, y;

    Vector2() {

    }

    Vector2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    Vector2(Vector2<T> copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public boolean equals(Object o) {
        Vector2<T> n = (Vector2<T>)o;
        return (x == n.x && y == n.y);
    }

    @Override
    public int hashCode() {
        int result = 42;
        result = 31*result + x.hashCode();
        result = 31*result + y.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new String("[" + x + ", " + y + "]");
    }
}
