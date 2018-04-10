package NonoTheRobot;

import java.util.*;

public class PathFinder {

    /**
     * Find the shortness path in a Explorable.
     * @param exp Input variable : contain the element at explore
     * @param path Output variable : contain the path found.
     * @return true if a path is found, else false
     */
    public static <T> boolean FindPath(Explorable<T> exp, List<T> path) {
        LinkedList<Node<T>> toVisit = new LinkedList<>();
        ArrayList<T> visited = new ArrayList<>();

        toVisit.add(new Node<T>(exp.NextStep(null).get(0), null));
        visited.add(exp.NextStep(null).get(0));

        while (!toVisit.isEmpty()) {
            Node<T> actual = toVisit.poll();
            if (exp.isFinish(actual.value)) {
                while (actual != null) {
                    path.add(0, actual.value);
                    actual = actual.parent;
                }
                return true;
            }
            ArrayList<T> neighbours = exp.NextStep(actual.value);
            for (T neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    System.out.println(neighbour.toString());
                    toVisit.add(new Node<T>(neighbour, actual));
                    visited.add(neighbour);
                }
            }
        }

        return false;
    }
}
