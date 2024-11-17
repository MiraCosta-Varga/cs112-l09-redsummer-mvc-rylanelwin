package cs112.lab09.controllers;

import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.Desktop;

public class EventController {

    private RevisedHistoricalEvent redSummerEvent;
    private String location, imageLocation;

    protected void initData(String location, String imageLocation, RevisedHistoricalEvent historicalEvent){
        this.location = location;
        this.imageLocation = imageLocation;
        this.redSummerEvent = new RevisedHistoricalEvent(historicalEvent);

        locationLabel.setText(this.location);
        dateLabel.setText(this.redSummerEvent.getEventDay().toString());
        descriptionLabel.setText(this.redSummerEvent.getDescription());
        revisedDescriptionLabel.setText(this.redSummerEvent.getRevisedDescription());
        eventImageView.setImage(new Image(getClass().getResourceAsStream(this.imageLocation)));

    }

    @FXML
    private ImageView eventImageView;
    @FXML
    private Hyperlink citationHyperlink;

    @FXML
    private Button closeButton;

    @FXML
    private Label locationLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label revisedDescriptionLabel;


    @FXML
    protected void onCloseButtonClicked(ActionEvent actionEvent){

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    protected void onCitationHyperlinkClicked(){
        if (Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(new URI(redSummerEvent.getCitation()));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported");
        }
    }
}
