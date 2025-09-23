package lk.ijse.javaFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ManageCourseController {

    @FXML
    private TableView<?> CourseEnrollment;

    @FXML
    private AnchorPane ancPane;

    @FXML
    private TableColumn<?, ?> colCourseId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colStdCourseId;

    @FXML
    private TableColumn<?, ?> colStdId;


    @FXML
    void btnStudentAddOnAction(ActionEvent event) {

    }

}
