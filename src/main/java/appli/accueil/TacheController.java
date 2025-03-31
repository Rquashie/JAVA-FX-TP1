package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Liste;
import model.Tache;
import model.Type;
import repository.ListeRepository;
import repository.TacheRepository;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TacheController implements Initializable {
    @FXML
    private TextField nomTacheTextField;

    @FXML
    private Button validerButton;

    @FXML
    private Label erreurLabel;

    TacheRepository tacheRepository = new TacheRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        erreurLabel.setVisible(false);
    }


    public void ajouterTache(javafx.event.ActionEvent event) throws SQLException, IOException {
            if(nomTacheTextField.getText().isEmpty()){
                erreurLabel.setVisible(true);
                erreurLabel.setText("Veuillez entrer un nom");
            }
            else {
                Liste listeselectionnee = tacheRepository.recupererListe();
                Type typeSelectionnee =  tacheRepository.recupererType();
                Tache tache = new Tache(nomTacheTextField.getText(),0, listeselectionnee.getId_liste(), typeSelectionnee.getIdType());
                boolean ajout = tacheRepository.ajouterTache(tache);
                if(ajout){
                    StartApplication.changeScene("AccueilTache");
                    tacheRepository.detruireInfoListe();
                    tacheRepository.detruireInfoType();
                }
            }
        }
    }