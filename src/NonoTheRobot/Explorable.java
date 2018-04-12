package NonoTheRobot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * A entity can be explorable with pathfinder.
 */
public interface Explorable<T> {

    /**
     * @param step Reference position.
     * @return List of neighbours position to step (which are not wall). If step is null, return start position.
     */
    ArrayList<T> NextStep(T step);

    /**
     * @param pos Check if this position is the end position.
     * @return True if the parameter is the end position, else False.
     */
    boolean isFinish(T pos);

}
