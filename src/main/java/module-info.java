module com.example.assignment1comp1011 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment1comp1011 to javafx.fxml;
    exports com.example.assignment1comp1011;
}