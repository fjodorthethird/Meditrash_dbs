package com.meditrashcorp.ui;

import com.mediTrash.app.SQL_functions.DataControlFunctions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    public static DataControlFunctions dcf;
    Parent root;
    Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        dcf = new DataControlFunctions();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = primaryStage;
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}