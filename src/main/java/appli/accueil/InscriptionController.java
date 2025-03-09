package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class InscriptionController {
    Button redirectionConnexionButton;
    public Button inscriptionButton;
    public Label nomLabel;
    public Label prenomLabel;
    public Label emailLabel;
    public Label mdpLabel;
    public Label confirmerLabel;
    @FXML
private TextField nomField ;
@FXML
private TextField prenomField ;
@FXML
private TextField emailField ;
@FXML
private PasswordField mdpField ;
@FXML
private PasswordField confirmerMdpField ;


@FXML
public void gestionInscription(ActionEvent actionEvent) {
    System.out.println("Nom : "+nomField.getText());
    System.out.println("Prenom : "+prenomField.getText());
    System.out.println("Email : "+emailField.getText());
    if(mdpField.getText().equals(confirmerMdpField.getText())) {
        System.out.println("Mot de passe similaire");
    }
    else{
        System.out.println("Les mots de passe doivent être similaire");
    }
}
public void redirectionConnexion(ActionEvent actionEvent) throws IOException {
    StartApplication.changeScene("Login");
}

    @FXML
    void initialize() {
        assert prenomField != null : "fx:id=\"prenomField\" was not injected: check your FXML file 'InscriptionView.fxml'.";
        assert nomField != null : "fx:id=\"nomField\" was not injected: check your FXML file 'InscriptionView.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'InscriptionView.fxml'.";
        assert mdpField != null : "fx:id=\"mdpField\" was not injected: check your FXML file 'InscriptionView.fxml'.";

    }
}
