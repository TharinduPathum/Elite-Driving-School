package lk.ijse.javaFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class CoursePageController {

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<?> courseTable;

    @FXML
    private AnchorPane ancPane;

    @FXML
    void btnAddCourseOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewEnrollOnAction(ActionEvent event) {

    }
}
