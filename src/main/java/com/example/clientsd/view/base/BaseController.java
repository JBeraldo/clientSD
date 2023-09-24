package com.example.clientsd.view.base;

import javafx.scene.Node;
import javafx.stage.Stage;

public class BaseController {

    public Stage getStage(Node element){
        return (Stage) element.getScene().getWindow();
    }
}
