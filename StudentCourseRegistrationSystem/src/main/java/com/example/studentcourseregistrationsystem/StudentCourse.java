package com.example.studentcourseregistrationsystem;

public class StudentCourse {
    private String id;
    private String name;
    private String courseName;
    private int creditHour;
    private boolean enrollmentStatus;

    public StudentCourse() {
    }

    public StudentCourse(String id, String name, String courseName, int creditHour, boolean enrollmentStatus) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.creditHour = creditHour;
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public boolean isEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public void setEnrollmentStatus(boolean enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", creditHour=" + creditHour +
                ", enrollmentStatus=" + enrollmentStatus +
                '}';
    }
}
