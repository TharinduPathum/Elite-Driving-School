package lk.ijse.javaFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;


public class LessonPageController {

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colInstId;

    @FXML
    private TableColumn<?, ?> colStdId;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableView<?> lessonTable;

    @FXML
    private AnchorPane ancPane;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnCreateOnAction(ActionEvent event) {

    }
}
