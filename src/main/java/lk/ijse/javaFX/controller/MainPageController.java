package lk.ijse.javaFX.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MainPageController {

    @FXML
    private AnchorPane ancPane;

    @FXML
    void btnAdmin(ActionEvent event) {
        navigateTo("view/AdminLogin.fxml");
    }

    @FXML
    void btnReceptionist(ActionEvent event) {
        navigateTo("view/ReceptionistLogin.fxml");

    }

    private void navigateTo(String path) {
        try {
            ancPane.getChildren().clear();

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));

            anchorPane.prefWidthProperty().bind(ancPane.widthProperty());
            anchorPane.prefHeightProperty().bind(ancPane.heightProperty());

            ancPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Page not found..!").show();
            e.printStackTrace();
        }
    }



}
