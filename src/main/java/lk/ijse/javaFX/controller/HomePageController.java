package lk.ijse.javaFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomePageController {

    @FXML
    private AnchorPane ancPane;

    @FXML
    void btnCourseOnAction(ActionEvent event) {
      navigateTo("/view/CoursePage.fxml");
    }

    @FXML
    void btnInstructorOnAction(ActionEvent event) {
      navigateTo("/view/InstructorPage.fxml");
    }

    @FXML
    void btnLessonOnAction(ActionEvent event) {
       navigateTo("/view/LessonPage.fxml");
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
      navigateTo("/view/StudentPage.fxml");
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
