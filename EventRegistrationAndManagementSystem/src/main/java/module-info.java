module com.example.eventregistrationandmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eventregistrationandmanagementsystem to javafx.fxml;
    exports com.example.eventregistrationandmanagementsystem;
}