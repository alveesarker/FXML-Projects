package com.example.vehiclerentalmanagementsystem;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class RentalManagementViewController {
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField durationidTextField;
    @javafx.fxml.FXML
    private TableColumn<Rental, Float> costColumn;
    @javafx.fxml.FXML
    private TextField nameidTextField;
    @javafx.fxml.FXML
    private TableColumn<Rental, String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<Rental, String> vehicleTypeColumn;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> filteredVehicleTypeComboBox;
    @javafx.fxml.FXML
    private TableView<Rental> rentalTableView;
    @javafx.fxml.FXML
    private TableColumn<Rental, Integer> durationColumn;
    @javafx.fxml.FXML
    private TableColumn<Rental, String> idColumn;

    private final List<Rental> rentalList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        vehicleTypeComboBox.getItems().addAll("Car", "Bike", "Truck", "Van");
        filteredVehicleTypeComboBox.getItems().addAll("Car", "Bike", "Truck", "Van");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDuration"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("rentalCost"));
    }

    @javafx.fxml.FXML
    public void handleAddButtonOnAction() {
        if (idTextField.getText().isEmpty()){
            showAlert("Enter rental id.");
            return;
        }

        if (nameidTextField.getText().isEmpty()){
            showAlert("Enter Customer Name.");
            return;
        }

        if (vehicleTypeComboBox.getValue() == null){
            showAlert("Enter vehicle Type.");
            return;
        }

        if (durationidTextField.getText().isEmpty()){
            showAlert("Enter rental duration.");
            return;
        }

//      String rentalId, String customerName, String vehicleType, int rentalDuration
        if (!isValidRentalID(idTextField.getText())) {
            showAlert("Invalid id!");
            return;
        }

        for (Rental r: rentalList){
            if (idTextField.getText().equals(r.getRentalId())){
                showAlert("Duplicate rental Id!");
                return;
            }
        }

        if (1 > Integer.parseInt(durationidTextField.getText()) || Integer.parseInt(durationidTextField.getText()) > 30) {
            showAlert("Invalid duration!");
            return;
        }

        Rental rentalCar = new Rental(
                idTextField.getText(),
                nameidTextField.getText(),
                vehicleTypeComboBox.getValue(),
                Integer.parseInt(durationidTextField.getText())
        );
        rentalCar.calculateTheRentalCost();
        rentalList.add(
                rentalCar
        );
        rentalTableView.getItems().clear();
        rentalTableView.getItems().addAll(rentalList);
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnAction() {
        rentalTableView.getItems().clear();
        for (Rental r : rentalList) {
            if (filteredVehicleTypeComboBox.getValue().equals(r.getVehicleType())) {
                rentalTableView.getItems().add(r);
            }
        }
    }

    public static boolean isValidRentalID(String rentalID) {
        return rentalID.matches("^RNT-\\d{4}$");
    }

    public void showAlert(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(message);
        a.showAndWait();
    }
}