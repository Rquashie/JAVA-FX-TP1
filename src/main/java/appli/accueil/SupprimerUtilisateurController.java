package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.awt.*;
import java.io.IOException;

public class SupprimerUtilisateurController {

    @FXML
    private javafx.scene.control.TextField email;
    @FXML
    private Label erreur;

    private UtilisateurRepository ur = new UtilisateurRepository();


    @FXML
    public void redirectionRetour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("Profile");
    }

    @FXML
    public void supprimer(ActionEvent actionEvent) throws IOException {
        boolean supprimer = ur.supprimerUtilisateurParEmail(email.getText());
        if (supprimer) {
            erreur.setText("Utilisateur supprimé");
        } else {
            erreur.setText("Utilisateur introuvable");

        }
    }
}

