package NonoTheRobot;

import java.util.ArrayList;

/**
 * A entity can be explorable with pathfinder.
 */
public interface Explorable<T> {

    /**
     *
     * @param step
     * @return
     */
    ArrayList<T> NextStep(T step);

    /**
     *
     * @param pos
     * @return
     */
    boolean isFinish(T pos);

}
