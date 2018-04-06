import java.util.ArrayList;

public interface Explorable<T> {

    ArrayList<T> NextStep(T step);
    boolean isFinish(T pos);

}
