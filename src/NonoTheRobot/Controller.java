package NonoTheRobot;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Controller {

    @FXML
    TextArea text;

    @FXML
    TextField pathFile;

    @FXML
    Button chooseFile;

    @FXML
    Button display;

    ArrayList<String> fullStep;
    int currentStep = 0;

    private DataModel model ;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    @FXML
    protected void displayLaby() {
        if(currentStep > 0) {
            text.setText(fullStep.get(currentStep));
        }else {
            text.setText(model.getLabyrintheString());
        }

        if(fullStep.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No path found", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    protected void nextStep() {
        if(currentStep<fullStep.size()-1) {
            currentStep++;
        }

        displayLaby();
    }

    @FXML
    protected void previousStep() {
        if(currentStep>0) {
            currentStep--;
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
        }
    }

}
