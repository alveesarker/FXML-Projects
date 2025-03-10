package com.example.eventregistrationandmanagementsystem;

import java.time.LocalDate;

public class Participant {
    private String participantId; //(must be an 8-digit number)
    private String fullName; //(only letters and spaces, not empty)
    private String emailAddress; //(must be a valid email format)
    private String phoneNumber; //(must be 11 digits, starts with "01")
    private String eventType; // (must be one of: "Workshop", "Hackathon", "Seminar")
    private LocalDate registrationDate; // (choose via DatePicker)
    private String studentStatus; //(Yes/No — use a CheckBox)

    public Participant() {
        this.participantId = null;
        this.fullName = null;
        this.emailAddress = null;
        this.phoneNumber = null;
        this.eventType = null;
        this.registrationDate = null;
        this.studentStatus = null;
    }

    public Participant(String participantID, String fullName, String emailAddress, String phoneNumber, String eventType, LocalDate registrationDate, String studentStatus) {
        this.participantId = participantID;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.eventType = eventType;
        this.registrationDate = registrationDate;
        this.studentStatus = studentStatus;
    }

    public String getParticipantID() {
        return participantId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setParticipantID(String participantID) {
        participantId = participantID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "ParticipantID='" + participantId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eventType='" + eventType + '\'' +
                ", registrationDate=" + registrationDate +
                ", studentStatus='" + studentStatus + '\'' +
                '}';
    }
}
