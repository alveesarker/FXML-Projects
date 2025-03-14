package com.example.midterm_2311249_5;
import java.io.*;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class BkashTransactionViewController {
    @javafx.fxml.FXML
    private Label showProcessMsgLable;
    @javafx.fxml.FXML
    private ComboBox<String> transactionTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<BKashTransaction, Integer> receiverNoCol;
    @javafx.fxml.FXML
    private ComboBox<String> filteredReceiverTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<BKashTransaction, Float> amountCol;
    @javafx.fxml.FXML
    private TextField transactionIdTextField;
    @javafx.fxml.FXML
    private TableColumn<BKashTransaction, Integer> senderNoCol;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TableColumn<BKashTransaction, Float> transChargeCol;
    @javafx.fxml.FXML
    private ComboBox<String> receiverTypeComboBox;
    @javafx.fxml.FXML
    private TableView<BKashTransaction> bkashTransTableView;
    @javafx.fxml.FXML
    private TextField receiverNoTextField;
    @javafx.fxml.FXML
    private TableColumn<BKashTransaction, String> receiverTypeCol;
    @javafx.fxml.FXML
    private TextField senderNoTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfTranDatePicker;
    @javafx.fxml.FXML
    private TextField filterSenderNoTextField;

    private final List<BKashTransaction> transactionList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        receiverTypeComboBox.getItems().addAll("Personal", "Agent", "Merchant");
        transactionTypeComboBox.getItems().addAll("TopUp", "SendMoney", "PayBill");
        filteredReceiverTypeComboBox.getItems().addAll("Personal", "Agent", "Merchant");

        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        receiverNoCol.setCellValueFactory(new PropertyValueFactory<>("receiverNo"));
        receiverTypeCol.setCellValueFactory(new PropertyValueFactory<>("receiverType"));
        senderNoCol.setCellValueFactory(new PropertyValueFactory<>("senderNo"));
        transChargeCol.setCellValueFactory(new PropertyValueFactory<>("transactionCharge"));

        // Load transactions from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transactions.dat"))) {
            List<BKashTransaction> loadedTransactions = (List<BKashTransaction>) ois.readObject();
            if (loadedTransactions != null) {
                transactionList.addAll(loadedTransactions); // Store in memory
                bkashTransTableView.getItems().addAll(transactionList); // Show in TableView
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous transactions found.");
        }
    }


    @javafx.fxml.FXML
    public void handleAddButton() {
        if (transactionTypeComboBox.getValue().equals("TopUp")) {
            if (receiverTypeComboBox.getValue().equals("Agent") || receiverTypeComboBox.getValue().equals("Merchant")) {
                showProcessMsgLable.setText("Select receiver type to Personal for top up transaction");
                return;
            }
        }

        BKashTransaction trans = new BKashTransaction(
                Integer.parseInt(senderNoTextField.getText()),
                Integer.parseInt(receiverNoTextField.getText()),
                receiverTypeComboBox.getValue(),
                transactionIdTextField.getText(),
                Float.parseFloat(amountTextField.getText()),
                transactionTypeComboBox.getValue(),
                dateOfTranDatePicker.getValue()
        );

        if (transactionTypeComboBox.getValue().equals("SendMoney") || transactionTypeComboBox.getValue().equals("PayBill")) {
            if (trans.getTransactionCharge() <= 0) {
                showProcessMsgLable.setText("For Send Money and Pay Bill transaction Type Transaction Charge must be greater than zero.");
                return;
            }
        }

        transactionList.add(trans); // Store in memory
        bkashTransTableView.getItems().add(trans); // Show in UI

        // Save updated list to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transactions.dat"))) {
            oos.writeObject(transactionList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        showProcessMsgLable.setText("Bkash transaction added successfully.");
    }


    @javafx.fxml.FXML
    public void handleAverageButton() {
        double total = 0;
        for (BKashTransaction bk : bkashTransTableView.getItems()) {
            total += bk.getTransactionCharge();
        }
        showProcessMsgLable.setText("Average charge paid by the sender is: " + total / bkashTransTableView.getItems().size());
    }

    @javafx.fxml.FXML
    public void handleFilterLoadButton() {
        bkashTransTableView.getItems().clear();
        for (BKashTransaction bk : transactionList) {
            if (filteredReceiverTypeComboBox.getValue().equals(bk.getReceiverType()) && Integer.parseInt(filterSenderNoTextField.getText()) == bk.getSenderNo()) {
                bkashTransTableView.getItems().add(bk);
            }
        }
    }
}