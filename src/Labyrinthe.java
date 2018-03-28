import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Labyrinthe implements Explorable<Vector2<Integer>>{

    public enum CaseType {
        EMPTY, LOCKED, VISITED
    }

    private int XStart, YStart;
    private int XEnd, YEnd;
    private CaseType[][] lab;
    private String name;

    private LinkedList<Node> actual;

    Labyrinthe(String path){
        try {
            FileReader file = new FileReader(path);
            BufferedReader buffer = new BufferedReader(file);

            String line;

            name = buffer.readLine();
            line = buffer.readLine();
            String[] start = line.split(":");
            XStart = Integer.parseInt(start[1]);
            YStart = Integer.parseInt(start[0]);

            line = buffer.readLine();
            String[] end = line.split(":");
            XEnd = Integer.parseInt(end[1]);
            YEnd = Integer.parseInt(end[0]);

            line = buffer.readLine();
            String[] size = line.split(":");
            lab = new CaseType[Integer.parseInt(size[1])][Integer.parseInt(size[0])];

            for (int y = 0; y < lab[0].length; y++) {
                line = buffer.readLine();
                for (int x = 0; x < lab.length; x++) {
                    lab[x][y] = (line.charAt(x) != ' ') ? CaseType.LOCKED : CaseType.EMPTY;
                }
            }

            lab[XStart][YStart] = CaseType.START;
            lab[XEnd][YEnd] = CaseType.END;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        for (CaseType[] b: lab) {
            System.out.println(Arrays.toString(b));
        }

        actual = new LinkedList<>();

        actual.add(new Node<Integer>(XStart, YStart, null));

        while (isFinish()) {
            Node<Integer> pos = actual.pop();
            if (lab[pos.vector.x][pos.vector.y] != CaseType.VISITED && lab[pos.vector.x][pos.vector.y] != CaseType.LOCKED) {
                lab[pos.vector.x][pos.vector.y] = CaseType.VISITED;
                Stack<Node> neighbours = NextStep(pos);
                while (!neighbours.empty()) {
                    Node<Integer> n = neighbours.pop();
                    if (lab[n.vector.x][n.vector.y] == CaseType.EMPTY) {
                        actual.add(n);
                    } else if (lab[n.vector.x][n.vector.y] == CaseType.END) {
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
    }


    @Override
    public List<> NextStep() {
        if(pos == null) {

        } else {
            LinkedList<Node> neighbours = new Stack<>();
            Stack<Node> next = new Stack<>();
            neighbours.add(new Node<>(pos.vector.x + 1, pos.vector.y, pos));
            neighbours.add(new Node<>(pos.vector.x - 1, pos.vector.y, pos));
            neighbours.add(new Node<>(pos.vector.x, pos.vector.y + 1, pos));
            neighbours.add(new Node<>(pos.vector.x, pos.vector.y - 1, pos));

            for (Node<Integer> n : neighbours) {
                if (n.vector.x >= 0 && n.vector.x < lab.length && n.vector.y >= 0 && n.vector.y < lab[0].length) {
                    next.push(n);
                }
            }
        }

        return next;
    }

    @Override
    public boolean isFinish() {
        return !actual.isEmpty();
    }

    public CaseType[][] getLab() {
        return lab;
    }
}