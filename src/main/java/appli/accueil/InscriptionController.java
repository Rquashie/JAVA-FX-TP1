package appli.accueil;
import javafx.scene.control.*;
import model.Utilisateur ;
import database.Database ;
import repository.UtilisateurRepository;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Long.toHexString;

public class InscriptionController {
@FXML
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
private CheckBox adminField;
@FXML
private CheckBox utilisateurField;
@FXML
private Label erreurInscription;

@FXML
UtilisateurRepository repo = new UtilisateurRepository();

@FXML
public void gestionInscription(ActionEvent actionEvent) throws IOException, SQLException {

    Utilisateur utilisateurTrouve = repo.getUtilisateurParEmail(emailField.getText());
    String nom = nomField.getText();
    String prenom = prenomField.getText();
    String email = emailField.getText();
    String mdp = mdpField.getText();
    mdp = String.valueOf(mdp.hashCode());

    if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || mdpField.getText().isEmpty()) {
        erreurInscription.setText("Veuillez remplir tous les champs");
        erreurInscription.setVisible(true);
        return;
    }
    if (!mdpField.getText().equals(confirmerMdpField.getText())) {
        erreurInscription.setText("Les mots de passe doivent être similaire");
        return;
    }

    if (utilisateurTrouve == null) {
        if (adminField.isSelected()) {
            Utilisateur utilisateur = new Utilisateur(nomField.getText(), prenomField.getText(), emailField.getText(), mdp, "admin");
            repo.ajouterUtilisateur(utilisateur);
            System.out.println(utilisateur.toString());
            StartApplication.changeScene("Login");
        } else if (utilisateurField.isSelected()) {
            Utilisateur utilisateur = new Utilisateur(nomField.getText(), prenomField.getText(), emailField.getText(), mdp, "utilisateur");
            repo.ajouterUtilisateur(utilisateur);
            System.out.println(utilisateur.toString());
            StartApplication.changeScene("Login");
        } else {
            erreurInscription.setText("Veuillez choisir un rôle");
            return;
        }
    }
    else{
        erreurInscription.setText("Un compte existe déja avec cette adresse");
        return;
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
