package com.example.eventregistrationandmanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManagementSystemViewController {
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
    private TableColumn<Participant, String> emailCol;
    @javafx.fxml.FXML
    private DatePicker registrationDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> filteredEventTypeComboBox;

    private final List<Participant> participantList = new ArrayList<>();
    @javafx.fxml.FXML
    private CheckBox filteredStudentStatusCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
        eventTypeComboBox.getItems().addAll("Workshop", "Hackathon", "Seminar");
        filteredEventTypeComboBox.getItems().addAll("Workshop", "Hackathon", "Seminar");

        idCol.setCellValueFactory(new PropertyValueFactory<>("participantId"));
        eventTypeCol.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        regDateCol.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
    }

    @javafx.fxml.FXML
    public void handleRegisterButtonOnClick(ActionEvent actionEvent) {
//        String participantID, String fullName, String emailAddress, String phoneNumber,
//        String eventType, LocalDate registrationDate, String studentStatus

        try {
            int inNumber = Integer.parseInt(idTextField.getText());
        } catch (NumberFormatException e) {
            showTotalRegNumText.setText("Invalid id number!");
            return;
        }

        if (idTextField.getText().length() != 8) {
            showTotalRegNumText.setText("Id length must be 8!");
            return;
        }

        for (Participant p: participantList) {
            if (idTextField.getText().equals(p.getParticipantId())){
                showTotalRegNumText.setText("Duplicate participant ID.");
                return;
            }
        }

        if (nameTextField.getText().isEmpty()) {
            showTotalRegNumText.setText("Enter name.");
        }

        if (emailTextField.getText().isEmpty()) {
            showTotalRegNumText.setText("Enter email.");
            return;
        }

        if (eventTypeComboBox.getValue() == null) {
            showTotalRegNumText.setText("Enter event type.");
            return;
        }

        if(registrationDatePicker.getValue()== null){
            showTotalRegNumText.setText("Enter registration date.");
            return;
        }

        String studStatus = "";
        if (studentStatusCheckBox.isSelected()) {
            studStatus = "Yes";
        } else {
            studStatus = "No";
        }

        participantList.add(
                new Participant(
                        idTextField.getText(),
                        nameTextField.getText(),
                        emailTextField.getText(),
                        phoneNumberTextField.getText(),
                        eventTypeComboBox.getValue(),
                        registrationDatePicker.getValue(),
                        studStatus
                )
        );

        participantTableView.getItems().clear();
        participantTableView.getItems().addAll(participantList);
        showTotalRegNumText.setText("Participant added successfully.");
    }

    @javafx.fxml.FXML
    public void handleShowTotalRegButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {

        String studStatus = "";
        if (filteredStudentStatusCheckBox.isSelected()) {
            studStatus = "Yes";
        } else {
            studStatus = "No";
        }
        participantTableView.getItems().clear();
        for (Participant p : participantList) {
            if (filteredEventTypeComboBox.getValue().equals(p.getEventType()) && studStatus.equals(p.getStudentStatus())) {
                participantTableView.getItems().add(p);
            }
        }
    }
}