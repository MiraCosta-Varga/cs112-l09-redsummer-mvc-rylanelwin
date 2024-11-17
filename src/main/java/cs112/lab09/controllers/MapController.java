package cs112.lab09.controllers;

import cs112.lab09.MainApplication;
import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import cs112.lab09.models.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MapController {

    private void openPopupWindow(String location) throws IOException{

        int index = Singleton.getIndex(location);
        RevisedHistoricalEvent rhEvent = Singleton.RH_EVENTS[index];
        String imageLocation = Singleton.RH_IMAGES[index];

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("event-view.fxml"));
        Parent eventViewParent = loader.load();

        EventController eventController = loader.getController();
        eventController.initData(location, imageLocation, rhEvent);

        Stage popupStage = new Stage();

        //popupStage.initModality(Modality.APPLICATION_MODAL);

        popupStage.setScene(new Scene(eventViewParent));

        popupStage.show();
    }
    @FXML
    protected void onSanFranciscoCaliforniaButtonClicked(ActionEvent actionEvent) throws IOException {
        this.openPopupWindow("San Francisco, CA");
    }
    @FXML
    protected void onBisbeeArizonaButtonClicked(ActionEvent actionEvent) throws IOException{
        this.openPopupWindow("Bisbee, AZ");
    }
}
