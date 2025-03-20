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
                StartApplication.changeScene("Projet");
        }
        public void redirectionTache(ActionEvent event) throws IOException {
                StartApplication.changeScene("Tache");
        }
        @FXML
        void initialize() {
                assert ajouterProjetButton != null : "fx:id=\"ajouterProjetButton\" was not injected: check your FXML file 'AdminView.fxml'.";
                assert ajouterTacheButton != null : "fx:id=\"ajouterTacheButton\" was not injected: check your FXML file 'AdminView.fxml'.";
                assert deconnexion != null : "fx:id=\"deconnexion\" was not injected: check your FXML file 'AdminView.fxml'.";
                assert modifierProjetButton != null : "fx:id=\"modifierProjetButton\" was not injected: check your FXML file 'AdminView.fxml'.";
                assert modifierTacheButton != null : "fx:id=\"modifierTacheButton\" was not injected: check your FXML file 'AdminView.fxml'.";
                assert supprimerProjetButton != null : "fx:id=\"supprimerProjetButton\" was not injected: check your FXML file 'AdminView.fxml'.";
                assert supprimerTacheButton != null : "fx:id=\"supprimerTacheButton\" was not injected: check your FXML file 'AdminView.fxml'.";

        }


}


