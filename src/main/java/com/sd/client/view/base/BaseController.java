package com.sd.client.view.base;

import com.sd.client.app.App;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseController {

    App app;

    private LongProperty state_id = new SimpleLongProperty(-1);

    public long getState_id() {
        return state_id.get();
    }

    public LongProperty state_idProperty() {
        return state_id;
    }

    public void setState_id(long state_id) {
        this.state_id.set(state_id);
    }

    public Stage getStage(Node element){
        return (Stage) element.getScene().getWindow();
    }
    public BaseController() {
    }

}
