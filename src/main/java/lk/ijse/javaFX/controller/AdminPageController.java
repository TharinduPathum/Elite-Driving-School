package lk.ijse.javaFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminPageController {

    @FXML
    private PasswordField txtAdminPassword;

    @FXML
    private TextField txtAdminUserName;

    @FXML
    private AnchorPane ancPane;

    @FXML
    void adminLoginBackIconOnAction(MouseEvent event) {
       navigateTo("/view/MainPage.fxml");
    }

    @FXML
    void btnAdminLoginOnAction(ActionEvent event) {

        try {
            String username = txtAdminUserName.getText().trim();
            String password = txtAdminPassword.getText().trim();

            // Dummy check
            if (username.equals("a") && password.equals("a")) {
                Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
                Stage stage = (Stage) txtAdminUserName.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Dashboard");
                stage.show();
            } else {
                throw new IllegalArgumentException("Invalid username or password.");
            }

        } catch (IllegalArgumentException e) {
            showError("Login Failed", e.getMessage());
        } catch (IOException e) {
            showError("System Error", "Failed to load Dashboard.fxml");
        } catch (Exception e) {
            showError("Unexpected Error", "An unexpected error occurred during login.");
            e.printStackTrace();
        }

    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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