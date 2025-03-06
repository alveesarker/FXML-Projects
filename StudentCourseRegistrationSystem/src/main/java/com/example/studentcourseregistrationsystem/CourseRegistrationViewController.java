package com.example.studentcourseregistrationsystem;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSearchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRegisterOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleTotalRegisterOnAction(ActionEvent actionEvent) {
    }
}