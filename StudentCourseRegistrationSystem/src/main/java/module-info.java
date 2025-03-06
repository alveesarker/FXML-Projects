module com.example.studentcourseregistrationsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentcourseregistrationsystem to javafx.fxml;
    exports com.example.studentcourseregistrationsystem;
}