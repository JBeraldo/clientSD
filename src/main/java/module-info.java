module com.example.clientsd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clientsd to javafx.fxml;
    exports com.example.clientsd;
}