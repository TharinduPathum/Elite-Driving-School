package lk.ijse.javaFX.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.javaFX.bo.BOFactory;
import lk.ijse.javaFX.bo.BOTypes;
import lk.ijse.javaFX.bo.custom.StudentBO;
import lk.ijse.javaFX.dto.tm.StudentsTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentPageController {

    @FXML
    private TableColumn<StudentsTM, String> colEmail;

    @FXML
    private TableColumn<StudentsTM, String> colId;

    @FXML
    private TableColumn<StudentsTM, String> colNIC;

    @FXML
    private TableColumn<StudentsTM, String> colName;

    @FXML
    private TableColumn<StudentsTM, String> colPhoneNo;

    @FXML
    private TableView<StudentsTM> studentTable;

    @FXML
    private Label custidValueLabel;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField nicField;

    @FXML
    private TextField phoneNoField;

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // C001
//        lblId.setText("C001");
        try {
            loadNextId();
            loadTableData();
        } catch (Exception e) {
            new Alert(
                    Alert.AlertType.ERROR, "Fail to load data..!"
            ).show();
        }

        studentBO.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                custidValueLabel.setText(newSelection.getId());
                nameField.setText(newSelection.getName());
                nicField.setText(newSelection.getAddress());
                emailField.setText(newSelection.getEmail());
                phoneNoField.setText(newSelection.getPhone());
            }
        });

    }

    private void loadTableData() throws SQLException {
        studentTable.setItems(FXCollections.observableArrayList(
                customerBO.getAllCustomer().stream().map(customerDTO ->
                        new CustomerTM(
                                customerDTO.getCustomerId(),
                                customerDTO.getName(),
                                customerDTO.getAddress(),
                                customerDTO.getEmail(),
                                customerDTO.getPhone()
                        )).toList()
        ));
    }


    private void loadNextId() throws Exception {
        String nextId = customerBO.getNextId();
        custidValueLabel.setText(nextId);
    }


    @FXML
    void BtnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnGoToProfilesOnAction(ActionEvent event) {

    }
}
