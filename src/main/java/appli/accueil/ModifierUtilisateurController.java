package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ModifierUtilisateurController {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField mdp;

    public void redirectionRetour() throws IOException {
        StartApplication.changeScene("Profile");
    }

}
