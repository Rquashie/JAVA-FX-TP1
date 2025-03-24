package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jdk.jshell.execution.Util;
import model.Liste;
import model.Utilisateur;
import repository.ListeRepository;
import session.SessionUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AccueilController implements Initializable {


@FXML
private Button ajouterListeButton;
@FXML
private TextField nomListeTextField;
@FXML
private Label erreurLabel;
@FXML
private TableView<Liste> tableView;
@FXML
private Button ajouterTacheButton ;
@FXML
private Button modifierTacheButton ;
@FXML
private Button supprimerTacheButton ;
@FXML
private Label nomListeLabel ;



ListeRepository listeRepository = new ListeRepository();




public void ajouterListe(ActionEvent event) throws IOException, SQLException {
    if (nomListeTextField.getText().isEmpty()) {
                        erreurLabel.setText("Veuillez entrer un nom");
    } else if (listeRepository.getListe(nomListeTextField.getText())) {
        erreurLabel.setText("Veuillez entrer une liste différente");
    } else {
        Liste liste = new Liste(nomListeTextField.getText());
        boolean ajout = listeRepository.ajouterListe(liste);
        if (ajout) {
            System.out.println("Liste ajouté");
        }
        if (liste.getId_liste() != 0) {
            System.out.println("Liste : " + liste.getId_liste());
            Utilisateur utilisateur = SessionUtilisateur.getInstance().getUtilisateur();
                        } else {
                                System.out.println("ID inconnu");
                        }
                }
        }
public void seDeconnecter(ActionEvent event) throws IOException {
                SessionUtilisateur.getInstance().deconnecter();
                StartApplication.changeScene("Connexion");

        }
public void actualiserListe(ActionEvent event) throws IOException {
                StartApplication.changeScene("Accueil");
        }
public void initialize(URL location, ResourceBundle resources) {
                String[][] colonnes = {
                        {"Id Liste", "id_liste"},
                        {"Nom", "nom"}
                };
                for (int i = 0; i < colonnes.length; i++) {
                        if (colonnes[i][0].equals("Id Liste")) {
                                TableColumn<Liste, Integer> maCol = new TableColumn<>(colonnes[i][0]);
                                maCol.setCellValueFactory(new PropertyValueFactory<>("id_liste"));
                                tableView.getColumns().add(maCol);
                        } else {
                                TableColumn<Liste, String> maCol = new TableColumn<>(colonnes[i][1]);
                                maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
                                tableView.getColumns().add(maCol);
                        }
                }

                ArrayList<Liste> lesListes = listeRepository.getToutesLesListes();
                for (Liste l : lesListes) {
                        tableView.getItems().add(l);
                }

    ajouterTacheButton.setVisible(false);
    modifierTacheButton.setVisible(false);
    supprimerTacheButton.setVisible(false);
}
@FXML
public void gestionListe() throws IOException {
                tableView.setOnMouseClicked(event -> {
                        if (event.getClickCount() == 2) {
                                Liste listeSelectionnee = tableView.getSelectionModel().getSelectedItem();
                                System.out.println("Id : " + listeSelectionnee.getId_liste() + "\nNom : " + listeSelectionnee.getNom());
                                ajouterTacheButton.setVisible(true);
                                modifierTacheButton.setVisible(true);
                                supprimerTacheButton.setVisible(true);
                                nomListeLabel.setVisible(false);
                                nomListeLabel.setManaged(false);
                                nomListeTextField.setVisible(false);
                                ajouterListeButton.setVisible(false);


                        }
                });
        }
}


