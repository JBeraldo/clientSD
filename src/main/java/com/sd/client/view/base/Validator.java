package com.sd.client.view.base;

import javafx.scene.control.Alert;

public class Validator {

    public static void errorAlert(ValidationResponse validationResponse){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(validationResponse.getTitle());
        alert.setHeaderText(validationResponse.getHeader());
        alert.setContentText(validationResponse.getContent());
        alert.showAndWait();
    }
    public static void warningAlert(ValidationResponse validationResponse) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(validationResponse.getTitle());
        alert.setHeaderText(validationResponse.getHeader());
        alert.setContentText(validationResponse.getContent());
        alert.showAndWait();
    }

}
