package com.meditrashcorp.ui;

import com.mediTrash.app.AuthorisedPersonChange.Functions;
import com.mediTrash.app.SQL_functions.DataControlFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.meditrashcorp.ui.MainApplication.dcf;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameText, userTF,icoTF;
    public static TextField usernameText_s;
    @FXML
    private PasswordField pswdText;
    public static PasswordField pswdText_s;
    // for passing info to the profile page
    public LoginController() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameText_s = usernameText;
        pswdText_s = pswdText;
    }

    private void openMain(){
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainPage.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openLogin() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 300, 500);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loginBtnOnAction(ActionEvent event)  {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        try {
            if (MainApplication.dcf.loginControl(usernameText.getText()) && MainApplication.dcf.passControl(pswdText.getText())) {
                if (usernameText.getText().equals("admin") && pswdText.getText().equals("qwerty123")) {
                    openAdmin();
                    return;
                }
                openMain();
            }
            else {
                Alert err = new Alert(Alert.AlertType.ERROR, "");
                err.initModality(Modality.APPLICATION_MODAL);
                err.initOwner(((Node)(event.getSource())).getScene().getWindow());
                err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
                err.getDialogPane().setHeaderText("Spatne udaje!");
                err.showAndWait();
                openLogin();
            }
        } catch (SQLException ignored) {

        }

    }

    public void openAdmin() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("admin.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Disp table of users and ap, select from table...
    public void delICO(ActionEvent e) {
        try {
            Functions f = new Functions();
            f.Delete("'"+icoTF.getText()+"'");
            ((Node)(e.getSource())).getScene().getWindow().hide();
            openLogin();
        } catch (Exception er) {
            Alert err = new Alert(Alert.AlertType.ERROR, "");
            err.initModality(Modality.APPLICATION_MODAL);
            err.initOwner(((Node)(e.getSource())).getScene().getWindow());
            err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
            err.getDialogPane().setHeaderText("Spatne ICO opravneny osoby!");
            err.showAndWait();
        }

    }
    public void delUSER(ActionEvent e) {
        try {
            dcf.DeleteUser(userTF.getText());
            ((Node)(e.getSource())).getScene().getWindow().hide();
            openLogin();
        } catch (Exception er) {
            Alert err = new Alert(Alert.AlertType.ERROR, "");
            err.initModality(Modality.APPLICATION_MODAL);
            err.initOwner(((Node)(e.getSource())).getScene().getWindow());
            err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
            err.getDialogPane().setHeaderText("Spatne jmeno uzivatele!");
            err.showAndWait();
        }
    }

    public void regBtnOnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("registration.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 300, 500);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}