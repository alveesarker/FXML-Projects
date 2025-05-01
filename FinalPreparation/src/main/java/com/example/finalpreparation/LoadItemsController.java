package com.example.finalpreparation;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class LoadItemsController
{
    @javafx.fxml.FXML
    private TableColumn<Rent, Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Rent, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Rent, String> floorCol;
    @javafx.fxml.FXML
    private TableColumn<Rent, String> roomCol;
    @javafx.fxml.FXML
    private TableView<Rent> rentTableView;

    @javafx.fxml.FXML
    public void initialize() {
        floorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roomCol.setCellValueFactory(new PropertyValueFactory<>("room"));

       File file = new File("data/rent.bin");
       try{
           FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis);
           while (true){
               try{
                   Rent r = (Rent)ois.readObject();
                   rentTableView.getItems().add(r);
               }catch (EOFException e){
                   break;
               }
           }
       } catch (IOException | ClassNotFoundException e){
           e.printStackTrace();
       }
    }}