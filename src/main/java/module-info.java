module com.example.clientsd {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.codec;
    requires jjwt.api;
    requires jjwt.impl;
    requires org.apache.logging.log4j;

    exports com.sd.client.view.address;
    exports com.sd.client.view;
    exports com.sd.client.app;
    exports com.sd.client.app.models;

    exports com.sd.client.app.packages to com.fasterxml.jackson.databind;
    exports com.sd.client.app.base to com.fasterxml.jackson.databind;
    exports com.sd.client.app.packages.data.login to com.fasterxml.jackson.databind;
    exports com.sd.client.app.packages.data.logout to com.fasterxml.jackson.databind;
    exports com.sd.client.app.packages.data.user to com.fasterxml.jackson.databind;


    opens com.sd.client.view.address to javafx.fxml;
    opens com.sd.client.view.login to javafx.fxml;
    opens com.sd.client.view.menu to javafx.fxml;
    opens com.sd.client.view.user to javafx.fxml;
    opens com.sd.client.view to javafx.fxml;
    exports com.sd.client.view.base to com.fasterxml.jackson.databind;
    exports com.sd.client.app.repositories;
    exports com.sd.client.app.storage;

}
