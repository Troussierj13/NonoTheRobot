package NonoTheRobot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;


public class Controller {

    @FXML
    TextArea text;

    @FXML
    TextField pathFile;

    @FXML
    Button chooseFile;

    ArrayList<String> fullStep;
    int currentStep = 0;

    private DataModel model ;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    private void displayLaby() {
        if(fullStep.isEmpty()) {
            text.setText(model.getLabyrintheString());
            Alert alert = new Alert(Alert.AlertType.ERROR, "No path found", ButtonType.OK);
            alert.showAndWait();
        } else {
            text.setText(fullStep.get(currentStep));
        }
    }

    protected void nextStep() {
        if (currentStep<fullStep.size()-1) {
            currentStep++;
        } else {
            currentStep = 0;
        }

        displayLaby();
    }

    @FXML
    protected void ZoomP() {
        text.setStyle("-fx-font-size: " + (text.getFont().getSize()+2) + ";");
    }

    @FXML
    protected void ZoomM() {
        if (text.getFont().getSize() > 5) {
            text.setStyle("-fx-font-size: " + (text.getFont().getSize() - 2) + ";");
        }
    }

    @FXML
    protected void openChooser() {
        FileChooser ch = new FileChooser();
        ch.setTitle("Choose file");
        File file = ch.showOpenDialog(model.getStage());

        pathFile.setText(file.getPath());
        if (!file.canRead() || !file.getPath().endsWith(".txt")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Can't read this file", ButtonType.OK);
            alert.showAndWait();
        } else {
            model.initLabyrinthe(file.getPath());
            fullStep = model.getFullStepString();
            currentStep = 0;
            displayLaby();
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(10000.f/fullStep.size()), event -> nextStep()));
            fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
            fiveSecondsWonder.play();
        }
    }

}
