package com.sd.client.view.base;

import com.sd.client.app.App;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseController implements Initializable {

    App app;

    public Stage getStage(Node element){
        return (Stage) element.getScene().getWindow();
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public BaseController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.app = getApp();
    }
}
