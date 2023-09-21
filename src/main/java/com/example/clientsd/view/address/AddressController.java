package com.example.clientsd.view.address;

import com.example.clientsd.app.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddressController {
    @FXML
    public TextField port;
    @FXML
    public TextField ip;
    @FXML
    protected void onHelloButtonClick() throws IOException {
        String ip_value = ip.getText();
        String port_value = port.getText();
        Client.connect(ip_value,port_value);
    }
}