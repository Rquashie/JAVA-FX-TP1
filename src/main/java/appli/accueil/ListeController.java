package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class ListeController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private DocFlavor.URL location;

    @FXML
    private Button ajouterTacheButton;

    @FXML
    private Label labelNomProjet;

    @FXML
    private TextField nomProjetField;

    @FXML
    private Button pageSuivanteButton;



}
