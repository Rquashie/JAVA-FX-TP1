package appli.accueil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TableauUserController implements Initializable {
    @FXML
    UtilisateurRepository repo = new UtilisateurRepository();
    @FXML
    private TableView<Utilisateur> tableView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [][] colonnes = {
                { "Id Utilisateur","idUser" },
                { "Nom","nom" },
                { "Prénom","prenom" },
                { "Email","mail" },
                { "Rôle","role" }
        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){
            //Création de la colonne avec le titre
            TableColumn<Utilisateur,String> maCol = new TableColumn<>(colonnes[i][0]);
//Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(
                    new PropertyValueFactory<Utilisateur,String>(colonnes[i][1]));
            //Ajout de la colonne dans notre tableau
            tableView.getColumns().add(maCol);
        }
        try {
            ArrayList<Utilisateur> lesUtilisateurs = repo.getTousLesUtilisateurs();
            for(Utilisateur u : lesUtilisateurs){
                tableView.getItems().add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


