import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Labyrinthe implements Explorable<Vector2<Integer>>{

    private Vector2<Integer> start;
    private Vector2<Integer> end;
    private boolean[][] lab;
    private String name;

    Labyrinthe(String path){
        start = new Vector2<>();
        end = new Vector2<>();

        try {
            FileReader file = new FileReader(path);
            BufferedReader buffer = new BufferedReader(file);

            String line;

            name = buffer.readLine();
            line = buffer.readLine();
            String[] sStart = line.split(":");
            start.x = Integer.parseInt(sStart[1]);
            start.y = Integer.parseInt(sStart[0]);

            line = buffer.readLine();
            String[] sEnd = line.split(":");
            end.x = Integer.parseInt(sEnd[1]);
            end.y = Integer.parseInt(sEnd[0]);

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
    }


    @Override
    public ArrayList<Vector2<Integer>> NextStep(Vector2<Integer> step) {
        ArrayList<Vector2<Integer>> next = new ArrayList<>();

        if(step == null) {
            next.add(start);
        } else {
            ArrayList<Vector2<Integer>> neighbours = new ArrayList<>();
            neighbours.add(new Vector2(step.x + 1, step.y));
            neighbours.add(new Vector2(step.x - 1, step.y));
            neighbours.add(new Vector2(step.x, step.y + 1));
            neighbours.add(new Vector2(step.x, step.y - 1));

            for (Vector2<Integer> n : neighbours) {
                if (n.x >= 0 && n.x < lab.length && n.y >= 0 && n.y < lab[0].length
                        && lab[n.x][n.y] == false) {
                    next.add(n);
                }
            }
        }

        return next;
    }

    @Override
    public boolean isFinish(Vector2<Integer> pos) {
        return end.equals(pos);
    }

    @Override
    public String toString() {
        String str = "";

        for (int y=0 ; y<lab[0].length ; y++) {
            for (int x=0 ; x<lab.length ; x++) {
                if (x == start.x && y == start.y) {
                    str += "D";
                } else if (x == end.x && y == end.y){
                    str += "A";
                } else if (lab[x][y]) {
                    str += "0";
                }
                else {
                    str += " ";
                }
            }
            str += "\n";
        }

        return str;
    }

    public char[][] getCharLab(){
        char[][] array = new char[lab.length][lab[0].length];

        for (int y=0 ; y<lab[0].length ; y++) {
            for (int x=0 ; x<lab.length ; x++) {
                if (x == start.x && y == start.y) {
                    array[x][y] = 'D';
                } else if (x == end.x && y == end.y){
                    array[x][y] = 'A';
                } else if (lab[x][y]) {
                    array[x][y] = '0';
                }
                else {
                    array[x][y] = ' ';
                }
            }
        }

        return array;
    }
}