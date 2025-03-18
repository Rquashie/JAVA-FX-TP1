package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button ajouterProjetButton;

    @FXML
    private Button ajouterTacheButton;

    @FXML
    private Button deconnexion;

    @FXML
    private Button modifierProjetButton;

    @FXML
    private Button modifierTacheButton;

    @FXML
    private Button supprimerProjetButton;

    @FXML
    private Button supprimerTacheButton;

    public void redirectionProjet(ActionEvent event) throws IOException {
        if(ajouterProjetButton.isDefaultButton())
        StartApplication.changeScene("Projet");
    }

}
