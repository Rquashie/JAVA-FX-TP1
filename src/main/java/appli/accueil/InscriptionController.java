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
    String mdp = String.valueOf(mdpField.hashCode() );
    if(adminField.isSelected()) {
        Utilisateur utilisateur = new Utilisateur(nomField.getText(), prenomField.getText(), emailField.getText(), mdp, "amin");
        if (!repo.getTousLesUtilisateurs().contains(utilisateur)) {
            repo.ajouterUtilisateur(utilisateur);
            StartApplication.changeScene("Login");
        }
        else{
            erreurInscription.setText("Utilisateur déja inscrit");
        }
    }
   else if(utilisateurField.isSelected()) {
        Utilisateur utilisateur = new Utilisateur(nomField.getText(), prenomField.getText(), emailField.getText(), mdp, "utilisateur");
        if (!repo.getTousLesUtilisateurs().contains(utilisateur)) {
            repo.ajouterUtilisateur(utilisateur);
        }
        else{
            erreurInscription.setText("Utilisateur déja inscrit");
        }
    }
   else{
       System.out.println("Veuillez choisir un bouton");
   }

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
