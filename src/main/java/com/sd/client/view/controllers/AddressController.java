package com.sd.client.view.controllers;

import com.sd.client.app.repositories.ConnectionRepository;
import com.sd.client.view.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddressController extends BaseController {
    @FXML
    public TextField port = new TextField();
    @FXML
    public TextField ip = new TextField();
    public Button connect_btn = new Button();
    @FXML
    protected void onHelloButtonClick()  throws InterruptedException{
        connect();
    }

    public AddressController() {
    }

    protected void connect() {
        String ip_value = ip.getText();
        String port_value = port.getText();
        ConnectionRepository.connect(ip_value,port_value);
        Client.changeScreen(getStage(connect_btn),"login/login.fxml");
    }



}