package com.example.clientsd.view.base;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BaseController {

    public Stage getStage(Node element){
        return (Stage) element.getScene().getWindow();
    }
    public void errorAlert(String title,String header,String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void warningAlert(String title,String header,String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
