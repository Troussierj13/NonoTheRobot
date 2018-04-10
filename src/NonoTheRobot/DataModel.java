package NonoTheRobot;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;

public class DataModel {
    private Stage primaryStage;
    LinkedList<Vector2<Integer>> path;
    Labyrinthe lab;

    DataModel(Stage stg) {
        if (this.primaryStage != null) {
            throw new IllegalStateException("Stage can only be initialized once");
        }
        this.primaryStage = stg;

        path = new LinkedList<>();
    }

    private DataModel() {}

    public void initLabyrinthe(String path) {
        lab = Parser.ParseLabyrinthe(path);
    }

    public Stage getStage() {
        return primaryStage;
    }

    public String getLabyrintheString() {
        return labToString(lab.getCharLab());
    }

    public ArrayList<String> getFullStepString() {
        ArrayList<String> fullStep = new ArrayList<>();
        path = new LinkedList<>();

        if(lab == null) {
            return null;
        } else {
            if (PathFinder.FindPath(lab, path)) {
                char[][] charLab = lab.getCharLab();
                fullStep.add(labToString(charLab));
                for (int i=0 ; i<path.size() ; i++) {
                    if(i>0) {
                          charLab[path.get(i).x][path.get(i).y] = 'R';
                        charLab[path.get(i-1).x][path.get(i-1).y] = '*';
                    } else {
                        charLab[path.get(i).x][path.get(i).y] = 'R';
                    }

                    fullStep.add(labToString(charLab));
                }
            }

            return fullStep;
        }
    }

    private String labToString(char[][] charLab) {
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