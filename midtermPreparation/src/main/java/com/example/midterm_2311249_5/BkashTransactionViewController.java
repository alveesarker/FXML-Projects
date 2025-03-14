package com.example.midterm_2311249_5;

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
    }

    @javafx.fxml.FXML
    public void handleAddButton() {
//        int senderNo, int receiverNo, String receiverType,
//        String transactionId, float amount, String transactionType, LocalDate dateOfTransaction

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

        transactionList.add(
                trans
        );
        showProcessMsgLable.setText("Bkash transaction added successfully.");
//        bkashTransTableView.getItems().addAll(transactionList);
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