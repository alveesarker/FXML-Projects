package com.example.finalpreparation;

import java.io.Serializable;

public class Rent implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String floor;
    private String room;


    public Rent(int id, String name, int age, String gender, String floor, String room) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.floor = floor;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoom() {
        return room;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
