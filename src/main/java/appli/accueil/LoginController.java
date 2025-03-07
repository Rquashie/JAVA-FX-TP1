package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button logButton;
    @FXML
    private Button inscriptionButton;
    @FXML
    private Button mdpOublieButton;

    @FXML
    public void verifConnexion(ActionEvent event) {

        String email = emailField.getText();
        String mdp = passwordField.getText();

        if (email.isEmpty() || mdp.isEmpty()) {
            System.out.println("Veuillez remplir les champs");
        } else if (mdp.equals("Azerty1234") && email.equals("r.quashie@lprs.fr")) {
            System.out.println("Connexion réussi");
        }
    }
    public void mdpOublie(ActionEvent event) {
        System.out.println("Mot de passe oublié");
    }
    @FXML
    public void redirectionInscription (ActionEvent event) throws IOException {
            StartApplication.changeScene("Inscription");
        }

    }
