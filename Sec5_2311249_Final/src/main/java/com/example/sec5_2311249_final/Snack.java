package com.example.sec5_2311249_final;

import java.io.Serializable;
import java.time.LocalDate;

public class Snack extends Food implements Serializable {
    private String manufacturer;
    private String snackType;
    private float price;
    private int vatPercentage;
    private boolean perishable;

    public Snack(String name, LocalDate prodDate, LocalDate expDate, String manufacturer, String snackType, float price, int vatPercentage, boolean perishable) {
        super(name, prodDate, expDate);
        this.manufacturer = manufacturer;
        this.snackType = snackType;
        this.price = price;
        this.vatPercentage = vatPercentage;
        this.perishable = perishable;
    }

    public Snack(String manufacturer, String snackType, float price, int vatPercentage, boolean perishable) {
        this.manufacturer = manufacturer;
        this.snackType = snackType;
        this.price = price;
        this.vatPercentage = vatPercentage;
        this.perishable = perishable;
    }

    public Snack(String name, LocalDate prodDate, LocalDate expDate) {
        super(name, prodDate, expDate);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSnackType() {
        return snackType;
    }

    public void setSnackType(String snackType) {
        this.snackType = snackType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(int vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "manufacturer='" + manufacturer + '\'' +
                ", snackType='" + snackType + '\'' +
                ", price=" + price +
                ", vatPercentage=" + vatPercentage +
                ", Perishable=" + perishable +
                ", name='" + name + '\'' +
                ", prodDate=" + prodDate +
                ", expDate=" + expDate +
                '}';
    }

    public void showDiscountPrice(){
        if(expDate.getYear() == LocalDate.now().getYear() && expDate.getDayOfMonth() == LocalDate.now().getDayOfMonth()-1){
            System.out.println("Discount Price: " + price * .5);
        } else {
            System.out.println("Discount Price: " + price * 0.1);
        }
    }
}
