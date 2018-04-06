import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TestLaby {

    public static void main(String[] arg) {
        LinkedList<Vector2<Integer>> path = new LinkedList<>();
        Labyrinthe lab = new Labyrinthe("/Users/troussierj/Documents/3il/1erAnnee/Java_Avancé/NonoTheRobot/resources/map1.txt");

        System.out.println();
        System.out.println(lab.toString());
        char[][] charLab = lab.getCharLab();

        if (PathFinder.FindPath(lab, path)) {
            for (int i=0 ; i<path.size() ; i++) {
                if(i>0) {
                    charLab[path.get(i).x][path.get(i).y] = 'R';
                    charLab[path.get(i-1).x][path.get(i-1).y] = '*';
                } else {
                    charLab[path.get(i).x][path.get(i).y] = 'R';
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println();
                System.out.println(labToString(charLab));
            }
        }
    }

    static private String labToString(char[][] charLab) {
        String str = "";

        for (int y=0 ; y<charLab[0].length ; y++) {
            for (int x=0 ; x<charLab.length ; x++) {
                str += charLab[x][y];
            }
            str += "\n";
        }

        return str;
    }

}
