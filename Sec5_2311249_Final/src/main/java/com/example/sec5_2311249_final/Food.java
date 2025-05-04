package com.example.sec5_2311249_final;

import java.io.Serializable;
import java.time.LocalDate;

public class Food implements Serializable {
    protected String name;
    protected LocalDate prodDate;
    protected LocalDate expDate;

    public Food(String name, LocalDate prodDate, LocalDate expDate) {
        this.name = name;
        this.prodDate = prodDate;
        this.expDate = expDate;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProdDate() {
        return prodDate;
    }

    public void setProdDate(LocalDate prodDate) {
        this.prodDate = prodDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", prodDate=" + prodDate +
                ", expDate=" + expDate +
                '}';
    }
}
