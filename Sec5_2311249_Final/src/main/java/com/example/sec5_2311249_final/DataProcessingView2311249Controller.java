package com.example.sec5_2311249_final;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class DataProcessingView2311249Controller
{
    @javafx.fxml.FXML
    private TableColumn<Snack, String> snackTypeCol;
    @javafx.fxml.FXML
    private ComboBox<String> snackTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Snack, String> manufacturerCol;
    @javafx.fxml.FXML
    private TableColumn<Snack, Boolean> isPerishableCol;
    @javafx.fxml.FXML
    private TableColumn<Snack, LocalDate> expDateCol;
    @javafx.fxml.FXML
    private TableView<Snack> dataTableView;
    @javafx.fxml.FXML
    private TableColumn<Snack, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Snack, LocalDate> prodDateCol;
    @javafx.fxml.FXML
    private ComboBox<String> manufacturerComboBox;
    @javafx.fxml.FXML
    private TableColumn<Snack, Float> priceCol;
    @javafx.fxml.FXML
    private TableColumn<Snack, Integer> vatCol;

    @javafx.fxml.FXML
    public void initialize() {
        manufacturerComboBox.getItems().addAll("Pran", "Olympic", "Akij");
        snackTypeComboBox.getItems().addAll("Chips", "Biscuit", "Soft Drinks", "Bread", "Cake");

        expDateCol.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        isPerishableCol.setCellValueFactory(new PropertyValueFactory<>("perishable"));
        manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        prodDateCol.setCellValueFactory(new PropertyValueFactory<>("prodDate"));
        snackTypeCol.setCellValueFactory(new PropertyValueFactory<>("snackType"));
        vatCol.setCellValueFactory(new PropertyValueFactory<>("vatPercentage"));
    }

    @javafx.fxml.FXML
    public void handleLoadDataOnAction(ActionEvent actionEvent) {
        File file = new File("Snack.bin");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while (true){
                try{
                    Snack snack = (Snack) ois.readObject();
                    if (manufacturerComboBox.getValue().equals(snack.getManufacturer()) && snackTypeComboBox.getValue().equals(snack.getSnackType())){
                        dataTableView.getItems().add(snack);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}