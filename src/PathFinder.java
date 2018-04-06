import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class PathFinder {

    private static LinkedList<Node> actual;

    public static <T> boolean FindPath(@NotNull Explorable<T> exp, List<T> path) {
        ArrayBlockingQueue<Node<T>> toVisit = new ArrayBlockingQueue<>(100);
        ArrayList<T> visited = new ArrayList<>();

        toVisit.add(new Node<T>(exp.NextStep(null).get(0), null));

        while(!toVisit.isEmpty()) {
            Node<T> actual = toVisit.poll();
            if(exp.isFinish(actual.value)) {
                while(actual != null) {
                    path.add(0, actual.value);
                    actual = actual.parent;
                }
                return true;
            }
            visited.add(actual.value);
            ArrayList<T> neighbours = exp.NextStep(actual.value);
            for(T neighbour : neighbours) {
                if(!visited.contains(neighbour)) {
                    toVisit.add(new Node<T>(neighbour, actual));
                }
            }
        }

        return false;
    }
}
