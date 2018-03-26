import org.jetbrains.annotations.NotNull;

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
    public boolean equals(@NotNull Object o) {
        Vector2<T> n = (Vector2<T>)o;
        return (x == n.x && y == n.y);
    }
}
