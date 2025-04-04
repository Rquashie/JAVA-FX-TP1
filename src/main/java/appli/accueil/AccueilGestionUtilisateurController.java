package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;

public class AccueilGestionUtilisateurController {

    private UtilisateurRepository ur = new UtilisateurRepository();

    @FXML
    public void initialize() {

    }
    @FXML
    public void redirectionModifierUtilisateur(ActionEvent event) throws IOException {
        StartApplication.changeScene("ModifierUtilisateur");
    }
    @FXML
    public void redirectionSupprimerUtilisateur(ActionEvent event) throws IOException {
        StartApplication.changeScene("SupprimerUtilisateur");
    }
    @FXML
    public void redirectionRetour(ActionEvent event) throws IOException, SQLException {
        StartApplication.changeScene("Profile");
        ur.detruireInfoUtilisateur();
    }
}
