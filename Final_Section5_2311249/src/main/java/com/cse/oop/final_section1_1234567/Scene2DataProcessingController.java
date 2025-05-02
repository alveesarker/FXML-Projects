package com.cse.oop.final_section1_1234567;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Scene2DataProcessingController {
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, String> diagonalCol;
    @javafx.fxml.FXML
    private TableView<Monitor2311249> dataTableView;
    @javafx.fxml.FXML
    private Text errorMessageText;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, String> resolutionCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, Integer> ppiCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor2311249, Float> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
        diagonalCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        ppiCol.setCellValueFactory(new PropertyValueFactory<>("ppi"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        resolutionCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
    }

    @javafx.fxml.FXML
    public void handleLoadDataButton(ActionEvent actionEvent) {
        File file = new File("monitors.bin");

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while (true){
                try{
                    Monitor2311249 m = (Monitor2311249) ois.readObject();
                    dataTableView.getItems().add(m);
                } catch (IOException e){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e){
//            nothing
        }
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene1-data-generation.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
//            d
        }
    }
}
