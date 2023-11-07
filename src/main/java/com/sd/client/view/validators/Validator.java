package com.sd.client.view.validators;

import com.sd.client.app.packages.SimpleResponse;
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
    public static void successAlert(ValidationResponse validationResponse) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(validationResponse.getTitle());
        alert.setHeaderText(validationResponse.getHeader());
        alert.setContentText(validationResponse.getContent());
        alert.showAndWait();
    }

    public static SimpleResponse responseErrors(SimpleResponse simpleResponse){
        if(simpleResponse.isError()){
            ValidationResponse vr = new ValidationResponse("Erro","Ação retornou o seguinte erro",simpleResponse.getMessage());
            Validator.errorAlert(vr);
        }
        return simpleResponse;
    }

}
