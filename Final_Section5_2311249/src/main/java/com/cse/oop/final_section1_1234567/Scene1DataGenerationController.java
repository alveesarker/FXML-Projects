package com.cse.oop.final_section1_1234567;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Scene1DataGenerationController {
    @javafx.fxml.FXML
    private ComboBox<String> diagonalComboBox;
    @javafx.fxml.FXML
    private TableView<Monitor2311249> detailsTableView;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, String> diagonalCol;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionComboBox;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TextField modelTextField;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, String> resolutionCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, Float> priceCol;
    @javafx.fxml.FXML
    private Text errorMessageText;

    @javafx.fxml.FXML
    public void initialize() {
        diagonalComboBox.getItems().addAll("17 inches", "19 inches", "22 inches", "24 inches");
        resolutionComboBox.getItems().addAll("HD", "HD+", "FULL-HD", "QHD");

        diagonalCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        resolutionCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
    }

    @javafx.fxml.FXML
    public void handleSaveButton(ActionEvent actionEvent) {
        File file = new File("monitors.bin");
        try{
            boolean existFile = file.exists();
            FileOutputStream fos = new FileOutputStream(file, true);

            ObjectOutputStream oos = existFile
                    ? new AppendableOutputStream(fos)
                    : new ObjectOutputStream(fos);
            for (Monitor2311249 m: detailsTableView.getItems()){
                oos.writeObject(m);
            }
            oos.close();

        } catch (IOException e){
//            ls
        }

    }

    @javafx.fxml.FXML
    public void handleNextButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddMonitorButton(ActionEvent actionEvent) {
        Monitor2311249 m = new Monitor2311249(
                modelTextField.getText(),
                resolutionComboBox.getValue(),
                diagonalComboBox.getValue(),
                Float.parseFloat(priceTextField.getText())
        );

        detailsTableView.getItems().add(m);
    }
}
