package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import javax.print.DocFlavor;
import java.lang.reflect.Type;
import java.util.ResourceBundle;


public class TacheController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private DocFlavor.URL location;

    @FXML
    private TextField nomTacheField;

    @FXML
    private TextField typeTacheField;

    @FXML
    private TextField couleurField ;

    UtilisateurRepository repo = new UtilisateurRepository();


    @FXML
    void handleTache(ActionEvent event) {
        if (!nomTacheField.getText().isEmpty() && !typeTacheField.getText().isEmpty()) {
            Type type = new Type(typeTacheField.getText(),couleurField.getText()) {


                }
            }
        }



    @FXML
    void initialize() {
        assert nomTacheField != null : "fx:id=\"nomTacheField\" was not injected: check your FXML file 'TacheView.fxml'.";
        assert typeTacheField != null : "fx:id=\"typeTacheField\" was not injected: check your FXML file 'TacheView.fxml'.";
        assert couleurField != null : "fx:id=\"couleurField\" was not injected: check your FXML file 'TacheView.fxml'.";
    }
}
