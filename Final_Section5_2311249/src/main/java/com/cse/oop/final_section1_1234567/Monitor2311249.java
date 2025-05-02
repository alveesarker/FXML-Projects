package com.cse.oop.final_section1_1234567;

import java.io.Serializable;

public class Monitor2311249 implements Serializable {
    private String model;
    private String resolution;
    private String diagonal;
    private float price;

    public Monitor2311249(String model, String resolution, String diagonal, float price) {
        this.model = model;
        this.resolution = resolution;
        this.diagonal = diagonal;
        this.price = price;
    }

    public Monitor2311249() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Monitor2311249{" +
                "model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", price=" + price +
                '}';
    }

    public static int getPPI(String resolution, int diagonal) {
        switch (resolution) {
            case "HD" -> {
                if (diagonal == 17) return 86;
                else if (diagonal == 19) return 77;
                else if (diagonal == 22) return 67;
                else if (diagonal == 24) return 61;
            }
            case "HD+" -> {
                if (diagonal == 17) return 108;
                else if (diagonal == 19) return 97;
                else if (diagonal == 22) return 83;
                else if (diagonal == 24) return 76;
            }
            case "Full-HD" -> {
                if (diagonal == 17) return 130;
                else if (diagonal == 19) return 116;
                else if (diagonal == 22) return 100;
                else if (diagonal == 24) return 92;
            }
            case "QHD" -> {
                if (diagonal == 17) return 173;
                else if (diagonal == 19) return 155;
                else if (diagonal == 22) return 134;
                else if (diagonal == 24) return 122;
            }
        }
        return -1;
    }

}
