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
                { "Id Utilisateur","id_utilisateur" },
                { "Nom","nom" },
                { "Prénom","prenom" },
                { "Email","email" },
                { "Rôle","role" }
        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){
            if (colonnes[i][0].equals("Id Utilisateur")) {
                TableColumn<Utilisateur, Integer> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
                tableView.getColumns().add(maCol);
            } else {
                TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
                tableView.getColumns().add(maCol);
            }
        }

        try {
            ArrayList<Utilisateur> lesUtilisateurs = repo.getTousLesUtilisateurs();
            System.out.println("Liste des utilisateurs : \n");
            for(Utilisateur u : lesUtilisateurs){
                tableView.getItems().add(u);
                System.out.println(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


