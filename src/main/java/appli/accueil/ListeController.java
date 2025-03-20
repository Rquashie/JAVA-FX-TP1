package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Liste;
import repository.ListeRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ListeController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enregistrerProjetButton;

    @FXML
    private Button retourButton;

    @FXML
    private TextField projetTextField ;

    @FXML
    private Label erreurLabel;

    ListeRepository repo = new ListeRepository() ;

    public void ajouterListe() throws IOException {
        if(projetTextField.getText().isEmpty()){
            erreurLabel.setVisible(true);
            erreurLabel.setText("Veuillez remplir tous les champs");
        }
        else if (!projetTextField.getText().isEmpty()){
            Liste projet = new Liste(projetTextField.getText()) ;
            repo.ajouterProjet(projet);


            StartApplication.changeScene("Tache");
        }
    }

    @FXML
    void initialize() {
        assert enregistrerProjetButton != null : "fx:id=\"enregistrerProjetButton\" was not injected: check your FXML file 'ListeView.fxml'.";
        assert retourButton != null : "fx:id=\"retourButton\" was not injected: check your FXML file 'ListeView.fxml'.";

    }
}
