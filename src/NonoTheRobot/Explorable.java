package NonoTheRobot;

import java.util.ArrayList;

/**
 * TODO
 * @param <T>
 */
public interface Explorable<T> {

    ArrayList<T> NextStep(T step);
    boolean isFinish(T pos);

}
