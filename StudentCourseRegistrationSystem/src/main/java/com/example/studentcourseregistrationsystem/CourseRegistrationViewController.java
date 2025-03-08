package com.example.studentcourseregistrationsystem;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationViewController {
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn<StudentCourse, String> courseNameCol;
    @javafx.fxml.FXML
    private Label showMessage;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> courseNameComboBox;
    @javafx.fxml.FXML
    private CheckBox enrolmentStatusCheckBox;
    @javafx.fxml.FXML
    private TableColumn<StudentCourse, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<StudentCourse, Boolean> statusCol;
    @javafx.fxml.FXML
    private TextField creditHourTextField;
    @javafx.fxml.FXML
    private TableView<StudentCourse> registerTableView;
    @javafx.fxml.FXML
    private TableColumn<StudentCourse, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<StudentCourse, Integer> creditHourCol;
    @javafx.fxml.FXML
    private ComboBox<String> filteredCourseNameComboBox;

    private final List<StudentCourse> studentCourseList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        courseNameComboBox.getItems().addAll("MAT110", "PHY 1101", "ENG1101", "CSC 1101", "CSC 1103");
        filteredCourseNameComboBox.getItems().addAll("MAT110", "PHY 1101", "ENG1101", "CSC 1101", "CSC 1103");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        courseNameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        creditHourCol.setCellValueFactory(new PropertyValueFactory<>("creditHour"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("enrollmentStatus"));
    }

    @javafx.fxml.FXML
    public void handleSearchOnAction(ActionEvent actionEvent) {
        registerTableView.getItems().clear();
        for (StudentCourse sc : studentCourseList) {
            if (filteredCourseNameComboBox.getValue().equals(sc.getCourseName())) {
                registerTableView.getItems().add(sc);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleRegisterOnAction(ActionEvent actionEvent) {
        if (idTextField.getText().isEmpty()) {
            showMessage.setText("Please Enter an ID.");
            return;
        }

        try {
            if (Integer.parseInt(idTextField.getText()) < 0) {
                showMessage.setText("Id must be Positive Integer!");
                return;
            }
        } catch (NumberFormatException e) {
            showMessage.setText("Invalid Id!");
            return;
        }

        if (nameTextField.getText().isEmpty()) {
            showMessage.setText("Please Enter a Name.");
            return;
        }

        if (courseNameComboBox.getValue() == null) {
            showMessage.setText("Please select a course.");
            return;
        }

        if (creditHourTextField.getText().isEmpty()) {
            showMessage.setText("Please Enter credit Hour.");
            return;
        }
//        String id, String name, String courseName, int creditHour, boolean enrollmentStatus
        String enStatus = "";
        if (enrolmentStatusCheckBox.isSelected()) {
            enStatus = "Yes";
        } else {
            enStatus = "No";
        }
        studentCourseList.add(
                new StudentCourse(
                        idTextField.getText(),
                        nameTextField.getText(),
                        courseNameComboBox.getValue(),
                        Integer.parseInt(creditHourTextField.getText()),
                        enStatus
                )
        );
        showMessage.setText("Added successfully.");

        registerTableView.getItems().clear();
        registerTableView.getItems().addAll(studentCourseList);
    }

    @javafx.fxml.FXML
    public void handleTotalRegisterOnAction(ActionEvent actionEvent) {
        int count = 0;
        for (StudentCourse sc: studentCourseList){
            if (sc.getEnrollmentStatus().equals("Yes")){
                count += 1;
            }
        }
        showMessage.setText("Enrollment Count: " + count);
    }
}