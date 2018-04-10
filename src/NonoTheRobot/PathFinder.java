package NonoTheRobot;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class PathFinder {

    private static LinkedList<Node> actual;

    public static <T> boolean FindPath(Explorable<T> exp, List<T> path) {
        ArrayBlockingQueue<Node<T>> toVisit = new ArrayBlockingQueue<>(1000000);
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
            //visited.add(actual.value);
            ArrayList<T> neighbours = exp.NextStep(actual.value);
            for(T neighbour : neighbours) {
                if(!visited.contains(neighbour)) {
                    System.out.println(neighbour.toString());
                    toVisit.add(new Node<T>(neighbour, actual));
                    visited.add(neighbour);
                }
            }
        }

        return false;
    }
}
