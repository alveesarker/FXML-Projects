package com.example.eventregistrationandmanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class EventManagementSystemViewController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TableColumn eventTypeCol;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView participantTableView;
    @javafx.fxml.FXML
    private Text showTotalRegNumText;
    @javafx.fxml.FXML
    private ComboBox eventTypeComboBox;
    @javafx.fxml.FXML
    private CheckBox studentStatusCheckBox;
    @javafx.fxml.FXML
    private TableColumn regDateCol;
    @javafx.fxml.FXML
    private TableColumn idCol;
    @javafx.fxml.FXML
    private TableColumn nameCol;
    @javafx.fxml.FXML
    private TableColumn emailCol;
    @javafx.fxml.FXML
    private DatePicker registrationDatePicker;
    @javafx.fxml.FXML
    private ComboBox filteredEventTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleRegisterButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleShowTotalRegButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
    }
}