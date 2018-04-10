package NonoTheRobot;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();
        Controller control = loader.getController();

        DataModel model = new DataModel(primaryStage);
        control.initModel(model);

        primaryStage.setTitle("NonoTheRobot");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.setMaxHeight(1000);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMinHeight(100);
        primaryStage.setMinWidth(100);
        primaryStage.show();
    }


    public static void main(String[] args) {
        ArrayList<Vector2<Integer>> visited = new ArrayList<>();
        Vector2<Integer> node = new Vector2<>(10, 20);

        visited.add(node);
        boolean b = visited.contains(node);

        launch(args);
    }
}
