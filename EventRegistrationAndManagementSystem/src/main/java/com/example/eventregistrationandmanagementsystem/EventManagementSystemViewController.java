package com.example.eventregistrationandmanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class EventManagementSystemViewController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> eventTypeCol;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<Participant> participantTableView;
    @javafx.fxml.FXML
    private Text showTotalRegNumText;
    @javafx.fxml.FXML
    private ComboBox<String> eventTypeComboBox;
    @javafx.fxml.FXML
    private CheckBox studentStatusCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Participant, LocalDate> regDateCol;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Participant,String> emailCol;
    @javafx.fxml.FXML
    private DatePicker registrationDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> filteredEventTypeComboBox;

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