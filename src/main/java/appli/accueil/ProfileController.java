package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import model.Utilisateur;
import repository.ListeRepository;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private TableView<Utilisateur> tableView;


    @FXML
    UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    public void initialize(URL location, ResourceBundle resources) {
        String[][] colonnes = {
                {"Id Utilisateur", "id_utilisateur"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            if (colonnes[i][0].equals("Id Utilisateur")) {
                TableColumn<Utilisateur, Integer> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
                tableView.getColumns().add(maCol);
            }
            else {
                TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][1]);
                maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
                tableView.getColumns().add(maCol);
            }
        }

        ArrayList<Utilisateur> lesUtilisateurs= null;
        try {
            lesUtilisateurs = utilisateurRepository.getTousLesUtilisateurs();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Utilisateur u : lesUtilisateurs) {
            tableView.getItems().add(u);
        }


    }
    @FXML
    public void gestionUtilisateur() throws IOException {
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Utilisateur utilisateurSelectionne = tableView.getSelectionModel().getSelectedItem();
                System.out.println("Id : " + utilisateurSelectionne.getId_utilisateur() + "\nNom : " + utilisateurSelectionne.getNom());
                utilisateurRepository.creerVueUtilisateur(utilisateurSelectionne);
                try {
                    StartApplication.changeScene("AccueilGestionUtilisateur");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                utilisateurRepository.creerVueUtilisateur(utilisateurSelectionne);
            }
        }) ;
    }

    public void redirectionRetour() throws IOException {
        StartApplication.changeScene("Liste");
    }
    }
