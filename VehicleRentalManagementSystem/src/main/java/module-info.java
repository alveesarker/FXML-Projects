module com.example.vehiclerentalmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vehiclerentalmanagementsystem to javafx.fxml;
    exports com.example.vehiclerentalmanagementsystem;
}