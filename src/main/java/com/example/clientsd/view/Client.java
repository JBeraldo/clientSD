package com.example.clientsd.view;

import com.example.clientsd.app.App;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("address.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();
    }
    public static void changeScreen(Stage stage,String resource){
        try {
            FXMLLoader loader = new FXMLLoader(Client.class.getResource(resource));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setOnHiding( event -> {App.die();} );
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}