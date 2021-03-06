package NonoTheRobot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

/**
 * Parse an explorable
 */
public class Parser {

    /**
     * parse a labyrinthe from a labyrinthe file
     * @param path path to labyrinthe file
     * @return new parse labyrinthe
     */
    public static Labyrinthe ParseLabyrinthe(String path) {
        Vector2<Integer> start = new Vector2<>();
        Vector2<Integer> end = new Vector2<>();
        boolean [][] lab = new boolean[0][0];
        String name = "";
        final String delimiter = ":";

        try {
            FileReader file = new FileReader(path);
            BufferedReader buffer = new BufferedReader(file);

            String line;

            name = buffer.readLine();
            line = buffer.readLine();
            String[] sStart = line.split(delimiter);
            start.x = Integer.parseInt(sStart[1]);
            start.y = Integer.parseInt(sStart[0]);

            line = buffer.readLine();
            String[] sEnd = line.split(delimiter);
            end.x = Integer.parseInt(sEnd[1]);
            end.y = Integer.parseInt(sEnd[0]);

            line = buffer.readLine();
            String[] size = line.split(delimiter);
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

        return new Labyrinthe(name, lab, start, end);
    }
}
