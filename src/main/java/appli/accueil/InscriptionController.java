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
import org.mindrot.jbcrypt.BCrypt;


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
    String mdpHache = BCrypt.hashpw(mdp, BCrypt.gensalt());

    if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || mdp.isEmpty()) {
        erreurInscription.setText("Veuillez remplir tous les champs");
        return;
    }
    else if (!mdp.equals(confirmerMdpField.getText())) {
        erreurInscription.setText("Les mots de passe doivent être similaire");
        return;
    }

    if (utilisateurTrouve == null) {
        Utilisateur utilisateur = new Utilisateur(nomField.getText(), prenomField.getText(), emailField.getText(), mdpHache);
        repo.ajouterUtilisateur(utilisateur);
        StartApplication.changeScene("Login");
    }

    else{
        erreurInscription.setText("Un compte existe déja avec cette adresse");

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
