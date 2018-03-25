import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Laby {
    private int XStart, YStart;
    private int XEnd, YEnd;
    private boolean[][] lab;
    private String name;

    private class Node {
        public Node parent;
        public int x, y;

        Node(int x, int y, Node parent){
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }

    Laby(String path){
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
        Vector<Node> visited = new Vector<>();
        LinkedList<Node> actual = new LinkedList<>();

        actual.add(new Node(XStart, YStart, null));

        while (!actual.isEmpty()) {
            Node pos = actual.pop();
            if (!visited.contains(pos)) {
                visited.add(pos);
                Stack<Node> neighbours = new Stack<>();
                neighbours.add(new Node(pos.x + 1, pos.y, pos));
                neighbours.add(new Node(pos.x - 1, pos.y, pos));
                neighbours.add(new Node(pos.x, pos.y + 1, pos));
                neighbours.add(new Node(pos.x, pos.y - 1, pos));
                while (!neighbours.empty()) {
                    Node n = neighbours.pop();
                    if (n.x >= 0 && n.x < lab.length && n.y >= 0 && n.y < lab[0].length) {
                        if (!lab[n.x][n.y]) {
                            if (pos.x == XEnd && pos.y == YEnd) {
                                System.out.println("END");
                            }
                            actual.add(n);

                            System.out.println(pos.x + " " + pos.y);
                        }
                    }
                }
            }
        }

    }
}
