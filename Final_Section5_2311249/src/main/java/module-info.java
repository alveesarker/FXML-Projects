module com.cse.oop.final_section1_1234567 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cse.oop.final_section1_1234567 to javafx.fxml;
    exports com.cse.oop.final_section1_1234567;
}