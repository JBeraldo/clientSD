package com.sd.client.view;

import com.sd.client.app.App;
import com.sd.client.view.base.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {

    static App app;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Client.class.getResource("address.fxml"));
        Scene scene = new Scene(loader.load(), 320, 240);
        stage.setTitle("Cliente");
        stage.setScene(scene);
        stage.show();
    }
    public static void changeScreen(Stage stage,String resource){
        try {
            FXMLLoader loader = new FXMLLoader(Client.class.getResource(resource));
            BaseController baseController = loader.<BaseController>getController();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public static void changeScreen(Stage stage,String resource,Long id){
        try {
            FXMLLoader loader = new FXMLLoader(Client.class.getResource(resource));
            Scene scene = new Scene(loader.load());
            BaseController baseController = loader.<BaseController>getController();
            baseController.setState_id(id);
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}