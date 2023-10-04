package com.example.clientsd.view.address;

import com.example.clientsd.app.App;
import com.example.clientsd.view.Client;
import com.example.clientsd.view.base.BaseController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

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

    protected void connect() throws InterruptedException {
        String ip_value = ip.getText();
        Integer port_value;
        try {
            port_value = extractPortNumber(port);
        } catch (Exception e) {
            errorAlert("erro","Erro ao informar porta",e.getMessage());
            return;
        }
        setApp(new App(ip_value,port_value));
        Client.changeScreen(getStage(connect_btn),"login/login.fxml",getApp());
    }

    protected Integer extractPortNumber(TextField element) throws Exception {
        String text = element.getText();
        if (!Objects.equals(text, "")){
            return Integer.parseInt(element.getText());
        }
        throw new Exception("Nenhum valor informado");
    }


}