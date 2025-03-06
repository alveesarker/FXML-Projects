package com.example.vehiclerentalmanagementsystem;

public class Rental {
    private String rentalId;
    private String customerName;
    private String vehicleType;
    private int rentalDuration;
    private float rentalCost;

    public Rental() {
    }

    public Rental(String rentalId, String customerName, String vehicleType, int rentalDuration) {
        this.rentalId = rentalId;
        this.customerName = customerName;
        this.vehicleType = vehicleType;
        this.rentalDuration = rentalDuration;
    }

    public String getRentalId() {
        return rentalId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public float getRentalCost() {
        return rentalCost;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public void setRentalCost(float rentalCost) {
        this.rentalCost = rentalCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId='" + rentalId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", rentalDuration=" + rentalDuration +
                ", rentalCost=" + rentalCost +
                '}';
    }

    public void calculateTheRentalCost() {
        switch (this.vehicleType) {
            case "Car" -> this.rentalCost = 50 * this.rentalDuration;
            case "Bike" -> this.rentalCost = 20 * this.rentalDuration;
            case "Truck" -> this.rentalCost = 80 * rentalDuration;
            case "Van" -> this.rentalCost = 60 * rentalDuration;
            default -> this.rentalCost = 0;
        }
    }
}
