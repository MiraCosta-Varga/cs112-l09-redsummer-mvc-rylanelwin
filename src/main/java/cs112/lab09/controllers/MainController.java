package cs112.lab09.controllers;

import cs112.lab09.MainApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController{
    @FXML
    private Button startButton;
    @FXML
    private Button quitButton;
    @FXML
    protected void onStartButtonClicked(ActionEvent actionEvent) throws IOException {

        Parent mapView = FXMLLoader.load(MainApplication.class.getResource("map-view.fxml"));
        Scene mapViewScene = new Scene(mapView);

        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(mapViewScene);

        window.show();
    }
    @FXML
    protected void onQuitButtonClicked(ActionEvent actionEvent){
        Platform.exit();
    }
}