module com.example.clientsd {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.clientsd.view.address;
    opens com.example.clientsd.view.address to javafx.fxml;
}