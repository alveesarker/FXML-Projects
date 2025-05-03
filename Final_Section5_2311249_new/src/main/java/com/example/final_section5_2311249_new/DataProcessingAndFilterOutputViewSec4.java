package com.example.final_section5_2311249_new;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class DataProcessingAndFilterOutputViewSec4 {
    @javafx.fxml.FXML
    private ComboBox<Integer> minYearExComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private TableColumn<Helper, String> jobToStringCol;
    @javafx.fxml.FXML
    private TableView<Helper> dataTableView;

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("Operations Manager", "Product Manager", "Business Analyst", "Project Manager", "Full Stack Developer", "Back-end Developer");
        minYearExComboBox.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        jobToStringCol.setCellValueFactory(new PropertyValueFactory<>("string"));
    }

    @javafx.fxml.FXML
    public void handleLoadDataButton(ActionEvent actionEvent) {
        File file = new File("JobApplication.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("hello");
            dataTableView.getItems().clear();
            while (true) {
                try {
                    JobApplication jobApplication = (JobApplication) ois.readObject();
                    if (designationComboBox.getValue().equals(jobApplication.getDesignationAppliedFor()) && jobApplication.getYearOfExperience() >= minYearExComboBox.getValue()) {
                        Helper ha = new Helper(jobApplication.toString());
                        dataTableView.getItems().add(ha);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

