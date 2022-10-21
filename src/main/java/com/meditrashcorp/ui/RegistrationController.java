package com.meditrashcorp.ui;

import com.mediTrash.app.Authorization.Registration;
import com.mediTrash.app.Data.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

import java.sql.SQLException;

import static com.meditrashcorp.ui.MainApplication.dcf;

public class RegistrationController {
    @FXML
    private TextField fir_provoz;

    @FXML
    private TextField fir_ulice;

    @FXML
    private TextField fir_heslo;

    @FXML
    private TextField fir_psc;

    @FXML
    private TextField fir_kod;

    @FXML
    private TextField fir_tel;

    @FXML
    private TextField fir_misto;

    @FXML
    private TextField fir_login;

    @FXML
    private TextField fir_nazev;

    @FXML
    private TextField fir_fax;

    @FXML
    private TextField fir_prav;

    @FXML
    private TextField fir_mail;

    public void registrationBtnOnAction(ActionEvent event) {
        Registration reg = new Registration();
        try {
            User u = new User(MainApplication.dcf.getID() + 1, fir_nazev.getText(), fir_ulice.getText(), fir_misto.getText(),
                    fir_psc.getText(), fir_kod.getText(), fir_tel.getText(), fir_mail.getText(), fir_fax.getText(), fir_prav.getText(),
                    fir_login.getText(), fir_heslo.getText(), fir_provoz.getText());
            reg.RegistrationForm(u);
        } catch (SQLException e) {
            Alert err = new Alert(Alert.AlertType.ERROR, "");
            err.initModality(Modality.APPLICATION_MODAL);
            err.initOwner(((Node)(event.getSource())).getScene().getWindow());
            err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
            err.getDialogPane().setHeaderText("Login jiz existuje");
            err.showAndWait();
        }
        catch (Exception e) {
            Alert err = new Alert(Alert.AlertType.ERROR, "");
            err.initModality(Modality.APPLICATION_MODAL);
            err.initOwner(((Node)(event.getSource())).getScene().getWindow());
            err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
            err.getDialogPane().setHeaderText("Error");
            err.showAndWait();
        }
    }
}
