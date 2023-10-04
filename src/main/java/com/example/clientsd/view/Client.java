package com.example.clientsd.view;

import com.example.clientsd.app.App;
import com.example.clientsd.view.base.BaseController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class Client extends Application {

    static App app;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Client.class.getResource("address.fxml"));
        Scene scene = new Scene(loader.load(), 320, 240);
        BaseController controller = loader.getController();
        controller.setApp(app);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();
    }
    public static void changeScreen(Stage stage,String resource,App app_socket){
        try {
            FXMLLoader loader = new FXMLLoader(Client.class.getResource(resource));
            Scene scene = new Scene(loader.load());
            BaseController controller = loader.getController();
            controller.setApp(app_socket);
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}