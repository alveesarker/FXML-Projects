package com.example.movieticketbookingsystem;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketBookingSystemViewController {
    @javafx.fxml.FXML
    private DatePicker showDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> genreComboBox;
    @javafx.fxml.FXML
    private TableColumn<Movie, String> genreCol;
    @javafx.fxml.FXML
    private ComboBox<String> filteredGenreComboBox;
    @javafx.fxml.FXML
    private TableColumn<Movie, String> seatAvailabilityCol;
    @javafx.fxml.FXML
    private TextField totalSeatTextField;
    @javafx.fxml.FXML
    private TableView<Movie> movieTableView;
    @javafx.fxml.FXML
    private TextField movieNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Movie, LocalDate> showDateCol;
    @javafx.fxml.FXML
    private CheckBox availabilityCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Movie, String> movieNameCol;

    private final List<Movie> movieList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        genreComboBox.getItems().addAll("Action", "Comedy", "Drama", "Horror", "Sci-Fi");
        filteredGenreComboBox.getItems().addAll("Action", "Comedy", "Drama", "Horror", "Sci-Fi");

        movieNameCol.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        seatAvailabilityCol.setCellValueFactory(new PropertyValueFactory<>("seatAvailability"));
        showDateCol.setCellValueFactory(new PropertyValueFactory<>("showDate"));
    }

    @javafx.fxml.FXML
    public void handleAddButtonOnAction(ActionEvent actionEvent) {
        if (movieNameTextField.getText().isEmpty()) {
            showMessage("Enter move name.");
            return;
        }

        for (Movie m : movieList) {
            if (movieNameTextField.getText().equals(m.getMovieName())) {
                showMessage("Duplicate Move name.");
                return;
            }
        }

        if (genreComboBox.getValue() == null) {
            showMessage("Enter genre.");
            return;
        }
        if (showDatePicker.getValue() == null) {
            showMessage("Enter show date.");
            return;
        }
        if (totalSeatTextField.getText().isEmpty()) {
            showMessage("Enter total seat number.");
            return;
        }
        try {
            if (Integer.parseInt(totalSeatTextField.getText()) < 0) {
                showMessage("Seat number must be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            showMessage("Enter valid number");
            return;
        }

        String avlSeat;
        if (availabilityCheckBox.isSelected()) {
            avlSeat = "Yes";
        } else {
            avlSeat = "No";
        }
//        String movieName, String genre, LocalDate showDate, String seatAvailability, int totalSeats
        movieList.add(
                new Movie(
                        movieNameTextField.getText(),
                        genreComboBox.getValue(),
                        showDatePicker.getValue(),
                        avlSeat,
                        Integer.parseInt(totalSeatTextField.getText())
                )
        );
        movieTableView.getItems().clear();
        movieTableView.getItems().addAll(movieList);
    }

    @javafx.fxml.FXML
    public void handleEnterGenreButtonOnAction(ActionEvent actionEvent) {
        movieTableView.getItems().clear();
        for (Movie m : movieList) {
            if (filteredGenreComboBox.getValue().equals(m.getGenre())) {
                movieTableView.getItems().add(m);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleFindMovieButtonOnAction(ActionEvent actionEvent) {
        movieTableView.getItems().clear();
        for (Movie m : movieList) {
            if (m.getSeatAvailability().equals("Yes")) {
                movieTableView.getItems().add(m);
            }
        }
    }

    public void showMessage(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(msg);
        a.showAndWait();
    }
}