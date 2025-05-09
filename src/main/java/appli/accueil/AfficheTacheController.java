package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import model.Tache;
import model.Utilisateur;
import repository.ListeRepository;
import repository.TacheRepository;
import session.SessionUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AfficheTacheController {

    @FXML
    TacheRepository tacheRepository = new TacheRepository();
    @FXML
    ListeRepository listeRepository = new ListeRepository();
    @FXML
    private TableView<Tache> tableView;

    Utilisateur utilisateurSelectionnee = SessionUtilisateur.getInstance().getUtilisateur();


    public void initialize(URL location, ResourceBundle resources) throws SQLException {
        String[][] colonnes = {
                {"Nom liste", "nom"},
                {"Nom tache", "nom"},
                {"Etat ", "etat"},
                {"Prenom utilisateur", "prenom"},
                {"Nom utilisateur", "nom"}

        };
        for (int i = 0; i < colonnes.length; i++) {
            if (colonnes[i][0].equals("Etat")) {
                TableColumn<Tache, Integer> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
                tableView.getColumns().add(maCol);
            }
            else {
                TableColumn<Tache, String> maCol = new TableColumn<>(colonnes[i][1]);
                maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
                tableView.getColumns().add(maCol);
            }
        }
        Liste listeSelectionnee = listeRepository.recupererInfoListe();
        ArrayList<Tache> lestaches = tacheRepository.getToutesLesTacheListe(utilisateurSelectionnee , listeSelectionnee);
        for (Tache t : lestaches) {
            tableView.getItems().add(t);
        }

    }

    @FXML
    public void gestionListe() throws IOException {
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Tache tacheSelectionnee = tableView.getSelectionModel().getSelectedItem();
                System.out.println("Nom : " + tacheSelectionnee.getNom());
                try {
                    StartApplication.changeScene("AccueilTache");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
