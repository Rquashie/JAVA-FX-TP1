package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import repository.ListeRepository;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AccueilTacheController  {
    @FXML
    private Button ajouterTacheButton;

    @FXML
    private Button modifierTacheButton;

    @FXML
    private Button retourListe;

    @FXML
    private Button supprimerTacheButton;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Label listeLabel ;

    private ListeRepository listeRepository = new ListeRepository() ;



    public void redirectionAjouterTache(javafx.event.ActionEvent event) throws IOException {
        StartApplication.changeScene("Type");
    }

    public void retourListe(javafx.event.ActionEvent event) throws IOException, SQLException {
        StartApplication.changeScene("Liste");
        listeRepository.detruireInfoListe();
    }
    public void initialize () throws SQLException {
        Liste listeSelectionnee = listeRepository.recupererInfoListe() ;
        listeLabel.setText("Gestion "+listeSelectionnee.getNom());
    }
}

