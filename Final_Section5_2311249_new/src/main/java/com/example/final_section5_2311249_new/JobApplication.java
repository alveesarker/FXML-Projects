package com.example.final_section5_2311249_new;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.ArrayList;

public class JobApplication {
    private int applicationNo;
    private String name;
    private String designationAppliedFor;
    private LocalDate dateOfApplication;
    private boolean isFreshGraduate;
    private int yearOfExperience;
    ArrayList<String> expertiseList;

    public JobApplication(int applicationNo, String name, String designationAppliedFor, LocalDate dateOfApplication, boolean isFreshGraduate, int yearOfExperience, ArrayList<String> expertiseList) {
        this.applicationNo = applicationNo;
        this.name = name;
        this.designationAppliedFor = designationAppliedFor;
        this.dateOfApplication = dateOfApplication;
        this.isFreshGraduate = isFreshGraduate;
        this.yearOfExperience = yearOfExperience;
        this.expertiseList = expertiseList;
    }

    public int getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(int applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignationAppliedFor() {
        return designationAppliedFor;
    }

    public void setDesignationAppliedFor(String designationAppliedFor) {
        this.designationAppliedFor = designationAppliedFor;
    }

    public LocalDate getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(LocalDate dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public boolean isFreshGraduate() {
        return isFreshGraduate;
    }

    public void setFreshGraduate(boolean freshGraduate) {
        isFreshGraduate = freshGraduate;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public ArrayList<String> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(ArrayList<String> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationNo=" + applicationNo +
                ", name='" + name + '\'' +
                ", designationAppliedFor='" + designationAppliedFor + '\'' +
                ", dateOfApplication=" + dateOfApplication +
                ", isFreshGraduate=" + isFreshGraduate +
                ", yearOfExperience=" + yearOfExperience +
                ", expertiseList=" + expertiseList +
                '}';
    }
}
