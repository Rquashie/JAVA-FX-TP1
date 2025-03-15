package appli.accueil;


import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button logButton;
    @FXML
    private Button inscriptionButton;
    @FXML
    private Button mdpOublieButton;
    @FXML
    private Button redirectionInscriptionButton;
    @FXML
    private Label erreurLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label emailLabel;

    @FXML
    UtilisateurRepository repo = new UtilisateurRepository();
    @FXML
    public void verifConnexion(ActionEvent event) {

        String email = emailField.getText();
        String mdp = passwordField.getText();

        if (email.isEmpty() || mdp.isEmpty()) {
            erreurLabel.setText("Erreur : Veuillez remplir les champs\"");
            return;
        }
        Utilisateur utilisateurTrouve = repo.getUtilisateurParEmail(email);


        if(utilisateurTrouve != null) {
            Utilisateur utilisateur = new Utilisateur(email, mdp);
            System.out.println("Connexion réussi");;
        }
        else {
            erreurLabel.setText("Mot de passe ou identifiant incorrect");
            return ;
        }

    }

    @FXML
    public void mdpOublie(ActionEvent event) {
        System.out.println("Mot de passe oublié");
    }
    @FXML
    public void redirectionInscription (ActionEvent event) throws IOException {

        StartApplication.changeScene("Inscription");
        }
    @FXML
    public void initialize() {
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert emailLabel != null : "fx:id=\"emailLabel\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert erreurLabel != null : "fx:id=\"erreurLabel\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert logButton != null : "fx:id=\"logButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert mdpOublieButton != null : "fx:id=\"mdpOublieButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert passwordLabel != null : "fx:id=\"passwordLabel\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert redirectionInscriptionButton != null : "fx:id=\"redirectionInscriptionButton\" was not injected: check your FXML file 'LoginView.fxml'.";

    }

    }
