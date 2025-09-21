package lk.ijse.javaFX.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class DashboardController {

    @FXML
    private AnchorPane ancPane;

    @FXML
    private Button courseButton;

    @FXML
    private Button instructorButton;

    @FXML
    private Button lessonButton;

    @FXML
    private Button studentButton;

    @FXML
    void btnCourse(ActionEvent event) {
        highlightButton(courseButton);
        navigateTo("/view/CoursePage.fxml");
    }

    @FXML
    void btnInstructor(ActionEvent event) {
        highlightButton(instructorButton);
        navigateTo("/view/InstructorPage.fxml");
    }

    @FXML
    void btnLesson(ActionEvent event) {
        highlightButton(lessonButton);
        navigateTo("/view/LessonPage.fxml");
    }

    @FXML
    void btnStudent(ActionEvent event) {
        highlightButton(studentButton);
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

    private void highlightButton(Button button) {
        resetButtonStyles();
        button.setStyle("-fx-background-color:  #ccf1f3;");
    }

    private void resetButtonStyles() {
        String defaultStyle = "-fx-background-color:  #5dbbea;";
        courseButton.setStyle(defaultStyle);
        studentButton.setStyle(defaultStyle);
        instructorButton.setStyle(defaultStyle);
        lessonButton.setStyle(defaultStyle);

    }
}
