package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Liste;
import repository.ListeRepository;

import java.net.URL;
import java.util.ResourceBundle;



public class ProjetController {
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

    public void ajouterListe(){
        if(projetTextField.getText().isEmpty()){
            erreurLabel.setVisible(true);
            erreurLabel.setText("Veuillez remplir tous les champs");
        }
        if (enregistrerProjetButton.isDefaultButton()){
            Liste projet = new Liste(projetTextField.getText()) ;
            repo.ajouterProjet(projet);
        }
    }

    @FXML
    void initialize() {
        assert enregistrerProjetButton != null : "fx:id=\"enregistrerProjetButton\" was not injected: check your FXML file 'ProjetView.fxml'.";
        assert retourButton != null : "fx:id=\"retourButton\" was not injected: check your FXML file 'ProjetView.fxml'.";

    }

}
