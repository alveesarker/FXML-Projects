module com.example.finalpreparation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalpreparation to javafx.fxml;
    exports com.example.finalpreparation;
}