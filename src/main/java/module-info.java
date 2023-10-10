module com.example.clientsd {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.codec;

    exports com.sd.client.view.address;
    exports com.sd.client.view;
    exports com.sd.client.app;

    exports com.sd.client.app.packages to com.fasterxml.jackson.databind;
    exports com.sd.client.app.base to com.fasterxml.jackson.databind;
    exports com.sd.client.app.package_data.login to com.fasterxml.jackson.databind;
    exports com.sd.client.app.packages.login to com.fasterxml.jackson.databind;
    exports com.sd.client.app.package_data.logout to com.fasterxml.jackson.databind;
    exports com.sd.client.app.packages.logout to com.fasterxml.jackson.databind;
    exports com.sd.client.app.package_data.user to com.fasterxml.jackson.databind;


    opens com.sd.client.view.address to javafx.fxml;
    opens com.sd.client.view.login to javafx.fxml;
    opens com.sd.client.view.menu to javafx.fxml;
    opens com.sd.client.view.user to javafx.fxml;
    opens com.sd.client.view to javafx.fxml;
    exports com.sd.client.view.base to com.fasterxml.jackson.databind;

}
