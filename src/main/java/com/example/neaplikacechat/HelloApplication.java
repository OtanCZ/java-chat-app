package com.example.neaplikacechat;

import com.example.neaplikacechat.client.ClientApplication;
import com.example.neaplikacechat.server.ServerApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static ClientApplication clientApplication;

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chat Application");
        stage.setScene(scene);
        stage.show();
        try {
            clientApplication = new ClientApplication(fxmlLoader.getController());
            clientApplication.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}