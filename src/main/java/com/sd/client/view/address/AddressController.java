package com.sd.client.view.address;

import com.sd.client.app.App;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import com.sd.client.view.base.ValidationResponse;
import com.sd.client.view.base.Validator;
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

    protected void connect() {
        String ip_value = ip.getText();
        String port_value = port.getText();
        if(ip_value.equals("") && port_value.equals("")){
            setApp(new App("127.0.0.1",8080));
        }else{
            setApp(new App(ip_value,Integer.valueOf(port_value)));
        }
        Client.changeScreen(getStage(connect_btn),"login/login.fxml",getApp());
    }



}