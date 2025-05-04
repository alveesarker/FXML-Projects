package com.example.sec5_2311249_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class DataCreationView2311249Controller
{
    @javafx.fxml.FXML
    private TextField snakNameTextField;
    @javafx.fxml.FXML
    private DatePicker expireDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> snackTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker productionDatePicker;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> manufacturerComboBox;
    @javafx.fxml.FXML
    private TextField vatPerTextField;
    @javafx.fxml.FXML
    private CheckBox perishableCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
        manufacturerComboBox.getItems().addAll("Pran", "Olympic", "Akij");
        snackTypeComboBox.getItems().addAll("Chips", "Biscuit", "Soft Drinks", "Bread", "Cake");
    }

    @javafx.fxml.FXML
    public void handleNextPageOnAction(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingView2311249.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        } catch (Exception e){
//            jj
        }
    }

    @javafx.fxml.FXML
    public void handleAppendSnackButtonOnAction(ActionEvent actionEvent) {
        if (perishableCheckBox.isSelected()){
            if (Integer.parseInt(vatPerTextField.getText()) != 0){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("vat percentage must be 0!");
                a.showAndWait();
                return;
            }
        } else{
            if (Integer.parseInt(vatPerTextField.getText()) != 5){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("vat percentage must be 5!");
                a.showAndWait();
                return;
            }
        }

//        String name, LocalDate prodDate, java.time.LocalDate expDate,
//                String manufacturer, String snackType, float price, int vatPercentage, boolean isPerishable
        Snack snack = new Snack(
                snakNameTextField.getText(),
                productionDatePicker.getValue(),
                expireDatePicker.getValue(),
                manufacturerComboBox.getValue(),
                snackTypeComboBox.getValue(),
                Float.parseFloat(priceTextField.getText()),
                Integer.parseInt(vatPerTextField.getText()),
                perishableCheckBox.isSelected()
        );

        File file = new File("Snack.bin");
        try{
            boolean fileExist = file.exists();
            FileOutputStream fos = new FileOutputStream(file, true);

            ObjectOutputStream oos = fileExist
                    ? new AppendableObjectOutputStream(fos)
                    : new ObjectOutputStream(fos);

            oos.writeObject(snack);
            oos.close();
        } catch (IOException e){
//            n
        }
    }
}