package com.example.midterm_2311249_5;
import java.io.*;
import java.time.LocalDate;

public class BKashTransaction implements Serializable {
    private int senderNo;
    private int receiverNo;
    private String receiverType;
    private String transactionId;
    private float amount;
    private String transactionType;
    private double transactionCharge;
    private LocalDate dateOfTransaction;

    public BKashTransaction() {
    }

    public BKashTransaction(int senderNo, int receiverNo, String receiverType, String transactionId, float amount, String transactionType, LocalDate dateOfTransaction) {
        this.senderNo = senderNo;
        this.receiverNo = receiverNo;
        this.receiverType = receiverType;
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.dateOfTransaction = dateOfTransaction;
        this.assignTransactionCharge(this.amount, this.transactionType);
    }

    public int getSenderNo() {
        return senderNo;
    }

    public int getReceiverNo() {
        return receiverNo;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public float getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionCharge() {
        return transactionCharge;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setSenderNo(int senderNo) {
        this.senderNo = senderNo;
    }

    public void setReceiverNo(int receiverNo) {
        this.receiverNo = receiverNo;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionCharge(double transactionCharge) {
        this.transactionCharge = transactionCharge;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    @Override
    public String toString() {
        return "BKashTransaction{" +
                "senderNo=" + senderNo +
                ", receiverNo=" + receiverNo +
                ", receiverType='" + receiverType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionCharge=" + transactionCharge +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }

    public void assignTransactionCharge(float amount, String transactionType) {
        switch (transactionType) {
            case "TopUp" -> this.transactionCharge = 0;
            case "SendMoney" -> this.transactionCharge = amount * 0.01; // 1k -> 10tk charge means 1tk -> 0.01tk charge
            case "PayBill" -> this.transactionCharge = amount * 0.02;
        }
    }
}
