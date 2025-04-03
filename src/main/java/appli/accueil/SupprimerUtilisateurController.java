package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.awt.*;
import java.io.IOException;

public class SupprimerUtilisateurController {

    @FXML
    private TextField id;

    @FXML
    UtilisateurRepository ur = new UtilisateurRepository();



    public void redirectionRetour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("Profile");
    }
    public void supprimer(ActionEvent actionEvent) throws IOException {
            ur.supprimerUtilisateurParId(id.getText());

        }
    }

