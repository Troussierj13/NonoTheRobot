import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Labyrinthe {
    private int XStart, YStart;
    private int XEnd, YEnd;
    private boolean[][] lab;
    private String name;

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
            lab = new boolean[Integer.parseInt(size[1])][Integer.parseInt(size[0])];

            for (int y = 0; y < lab[0].length; y++) {
                line = buffer.readLine();
                for (int x = 0; x < lab.length; x++) {
                    lab[x][y] = line.charAt(x) != ' ';
                }
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        for (boolean[] b: lab) {
            System.out.println(Arrays.toString(b));
        }
        LinkedList<Node> visited = new LinkedList<>();
        LinkedList<Node> actual = new LinkedList<>();

        actual.add(new Node<Integer>(XStart, YStart, null));

        while (!actual.isEmpty()) {
            Node<Integer> pos = actual.pop();
            if (!visited.contains(pos)) {
                visited.add(pos);
                Stack<Node> neighbours = new Stack<>();
                neighbours.add(new Node<>(pos.vector.x + 1, pos.vector.y, pos));
                neighbours.add(new Node<>(pos.vector.x - 1, pos.vector.y, pos));
                neighbours.add(new Node<>(pos.vector.x, pos.vector.y + 1, pos));
                neighbours.add(new Node<>(pos.vector.x, pos.vector.y - 1, pos));
                while (!neighbours.empty()) {
                    Node<Integer> n = neighbours.pop();
                    if (n.vector.x >= 0 && n.vector.x < lab.length && n.vector.y >= 0 && n.vector.y < lab[0].length) {
                        if (!lab[n.vector.x][n.vector.y]) {
                            if (pos.vector.x == XEnd && pos.vector.y == YEnd) {
                                System.out.println("END");
                                while (n.parent!=null) {
                                    System.out.println(n.vector.x + " " + n.vector.y);
                                    n = n.parent;
                                }
                                break;
                            }
                            actual.add(n);
                        }
                    }
                }
            }
        }

    }
}