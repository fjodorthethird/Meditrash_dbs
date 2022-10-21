package com.meditrashcorp.ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    Parent root;
    @FXML
    private BorderPane mainContainer;

    @FXML
    public void profileBtnOnAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            ProfileController.usernameL_s.setText(LoginController.usernameText_s.getText());
            ProfileController.pswdL_s.setText("*".repeat(LoginController.pswdText_s.getText().length()));
            ProfileController.zarizeniL_s.setText(MainApplication.dcf.getZar("'" + LoginController.usernameText_s.getText() + "'"));
        } catch (Exception ignored) {
        }
        mainContainer.setCenter(root);

    }
    @FXML
    public void insertBtnOnAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("InsertTrash.fxml"));
        } catch (Exception ignored) {
        }
        mainContainer.setCenter(root);
    }

    @FXML
    public void historyBtnOnAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("history.fxml"));
        } catch (Exception ignored) {
        }
        mainContainer.setCenter(root);
    }

    @FXML
    public void signOutBtnOnAction(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Scene scene = new Scene( FXMLLoader.load(getClass().getResource("login.fxml")));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


}
