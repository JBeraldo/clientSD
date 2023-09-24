module com.example.clientsd {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    exports com.example.clientsd.view.address;
    exports com.example.clientsd.view;
    exports com.example.clientsd.app;

    exports com.example.clientsd.app.packages to com.fasterxml.jackson.databind;
    exports com.example.clientsd.app.base to com.fasterxml.jackson.databind;
    exports com.example.clientsd.app.data.login to com.fasterxml.jackson.databind;

    opens com.example.clientsd.view.address to javafx.fxml;
    opens com.example.clientsd.view.login to javafx.fxml;
    opens com.example.clientsd.view to javafx.fxml;

}
