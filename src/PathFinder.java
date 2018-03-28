import java.util.LinkedList;
import java.util.Stack;

public class PathFinder {

    private static LinkedList<Node> actual;

    public static <T> LinkedList<T> FindPath(Explorable<T> exp) {
        LinkedList<Vector2<Integer>> res = new LinkedList<>();

        actual = new LinkedList<>();

        actual.add(new Node<Integer>(lab.getStartPos.x, lab.getStartPos.x, null));

        while (lab.isFinish()) {
            Node<Integer> pos = actual.pop();
            if (lab.getLab()[pos.vector.x][pos.vector.y] != Labyrinthe.CaseType.VISITED && lab.getLab()[pos.vector.x][pos.vector.y] != Labyrinthe.CaseType.LOCKED) {
                lab.getLab()[pos.vector.x][pos.vector.y] = Labyrinthe.CaseType.VISITED;
                Stack<Node> neighbours = lab.NextStep(pos);
                while (!neighbours.empty()) {
                    Node<Integer> n = neighbours.pop();
                    if (lab[n.vector.x][n.vector.y] == Labyrinthe.CaseType.EMPTY) {
                        actual.add(n);
                    } else if (lab[n.vector.x][n.vector.y] == Labyrinthe.CaseType.END) {
                        System.out.println("END");
                        while (n.parent!=null) {
                            System.out.println(n.vector.x + " " + n.vector.y);

                            n = n.parent;
                            actual.clear();
                        }
                        break;
                    }
                }
            }
        }

        return res;
    }
}
