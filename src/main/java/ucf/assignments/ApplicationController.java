package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ApplicationController extends javafx.application.Application {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Rawr");
    }

    @Override
    public void start(Stage primaryStage) {

    }
}