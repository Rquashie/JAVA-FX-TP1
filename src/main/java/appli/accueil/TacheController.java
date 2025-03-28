package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Tache;
import model.Type;
import repository.TacheRepository;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TacheController {
    @FXML
    private Button enregistreNomTacheButton;

    @FXML
    private Button enregistrerTypeButton;

    @FXML
    private TextField nomTacheTextField;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TextField typeTacheTextField;

    @FXML
    private Button validerButton;

    @FXML
    private Label erreurLabel;

    TacheRepository tr = new TacheRepository();


    public void ajouterType(ActionEvent event) throws SQLException {
        if (typeTacheTextField.getText().isEmpty()) {
            erreurLabel.setText("Veuillez remplir tous les champs");
        }
        else {
            tr.ajouterType(new Type(typeTacheTextField.getText(),"blue"));
        }
    }
    public void ajouterTache(ActionEvent event) throws SQLException {
        if (nomTacheTextField.getText().isEmpty()) {
            erreurLabel.setText("Veuillez remplir tous les champs");
        }
       // else {
            //tr.ajouterTache(new Tache(nomTacheTextField.getText(),0,));
        }

    }


