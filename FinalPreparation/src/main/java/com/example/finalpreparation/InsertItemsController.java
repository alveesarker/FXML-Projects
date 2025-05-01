package com.example.finalpreparation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InsertItemsController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roomComboBox;
    @javafx.fxml.FXML
    private ToggleGroup gender;
    @javafx.fxml.FXML
    private ComboBox<String> floorComboBox;
    @javafx.fxml.FXML
    private RadioButton femaleRadio;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private RadioButton maleRadio;
    @javafx.fxml.FXML
    private TextField ageTextField;

    @javafx.fxml.FXML
    public void initialize() {
        floorComboBox.getItems().addAll("1st", "2nd", "3rd", "4th", "5th");
        roomComboBox.getItems().addAll("Bed Room 1", "Bed Room 2", "Bed Room 3", "Partition Room");
    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {
        String gender = "Male";
        if (femaleRadio.isSelected()){
            gender = "Female";
        }
        Rent r = new Rent(Integer.parseInt(idTextField.getText()), nameTextField.getText(), Integer.parseInt(ageTextField.getText()), gender, floorComboBox.getValue(), roomComboBox.getValue());

        File file = new File("data/rent.bin");
        try {
            boolean exists = file.exists();
            FileOutputStream fos = new FileOutputStream(file, true);

            ObjectOutputStream oos = exists ? new AppendableObjectStream(fos) : new ObjectOutputStream(fos);
            oos.writeObject(r);
            oos.close();
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void handleNextButton(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("load-items.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
//            nothing
        }


    }
}