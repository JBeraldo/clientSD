package com.example.clientsd.view.address;

import com.example.clientsd.app.App;
import com.example.clientsd.view.Client;
import com.example.clientsd.view.base.BaseController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddressController extends BaseController {
    @FXML
    public TextField port;
    @FXML
    public TextField ip;
    public Button connect_btn;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        port.setText("10008");
        ip.setText("127.0.0.1");
        String ip_value = ip.getText();
        Integer port_value = Integer.parseInt(port.getText());
        App.connect(ip_value,port_value);
        Client.changeScreen(getStage(connect_btn),"login/login.fxml");
    }


}