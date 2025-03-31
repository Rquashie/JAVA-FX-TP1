package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Liste;
import model.Tache;
import model.Type;
import repository.TacheRepository;
import repository.TypeRepository;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TypeController  implements Initializable {

    @FXML
    private TextField couleurTextField;

    @FXML
    private Button enregistreNomTacheButton;

    @FXML
    private TextField typeTacheTextField;

    @FXML
    private Label erreurLabel;

    TypeRepository typeRepository = new TypeRepository();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        erreurLabel.setVisible(false);
    }

    public void ajouterType(javafx.event.ActionEvent event) throws SQLException, IOException {
        if (typeTacheTextField.getText().isEmpty() || couleurTextField.getText().isEmpty()) {
            erreurLabel.setText("Veuillez remplir tous les champs");
        } else {
            Type typeAjoutee = new Type(typeTacheTextField.getText(), couleurTextField.getText());
            int idTypeAjoutee = typeRepository.ajouterType(typeAjoutee);
            if(idTypeAjoutee != 0){
                typeRepository.creerVuesType(idTypeAjoutee);
            }

            StartApplication.changeScene("Tache");
        }
    }
}
