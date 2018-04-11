package NonoTheRobot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Labyrinthe with 2 dimension.
 * Is a array to case, a case can be a wall or not.
 * Has a start position and a end position.
 * A labyrinth have a name.
 */
public class Labyrinthe implements Explorable<Vector2<Integer>>{

    private Vector2<Integer> start;
    private Vector2<Integer> end;
    private boolean[][] lab;
    private String name;

    /**
     *
     * @param name Name of this labyrinth
     * @param lab two-dimensional array of boolean which contain wall and free space of the labyrinth
     * @param start Starting position of the labyrinth
     * @param end Ending position of the labyrinth
     */
    Labyrinthe(String name, boolean[][] lab, Vector2<Integer> start, Vector2<Integer> end){
        this.name = name;
        this.lab = lab;
        this.start = start;
        this.end = end;
    }

    /**
     * This function is override to function of Explorable.
     * @param step Reference position.
     * @return List of neighbours position to step (which are not wall). If step is null, return start position.
     */
    @Override
    public ArrayList<Vector2<Integer>> NextStep(Vector2<Integer> step) {
        ArrayList<Vector2<Integer>> next = new ArrayList<>();

        if (step == null) {
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

    /**
     * This function is override to function of Explorable.
     * @param pos Check if this position is the end position.
     * @return True if the parameter is the end position, else False.
     */
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

    /**
     * Convert two-dimensional array of boolean to two-dimensional array of characters.
     * Replace start position by 'D' and end position to 'A'.
     * Replace the wall by '0' and free space by ' '.
     * @return A two-dimensional array of characters that contains the elements of the labyrinth.
     */
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

    /**
     * @return Name of this labyrinth.
     */
    public String getName() {
        return name;
    }
}