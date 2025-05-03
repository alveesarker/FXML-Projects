package com.example.final_section5_2311249_new;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class DataCreationToFileViewSec4Controller
{
    @javafx.fxml.FXML
    private TextField jobAppNoTextField;
    @javafx.fxml.FXML
    private CheckBox gradCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> yearOfExperienceComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField experienceTextField;
    @javafx.fxml.FXML
    private DatePicker applicationDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("Operations Manager", "Product Manager", "Business Analyst", "Project Manager", "Full Stack Developer", "Back-end Developer");
        yearOfExperienceComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @javafx.fxml.FXML
    public void handleAddExperienceButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleNextButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingAndFilterOutputViewSec4.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void handleAppendButton(ActionEvent actionEvent) {
    }
}