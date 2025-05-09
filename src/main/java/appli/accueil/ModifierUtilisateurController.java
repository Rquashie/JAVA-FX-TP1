package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLException;

public class ModifierUtilisateurController {
    @FXML
    private TextField nomTextField;
    @FXML
    private TextField prenomTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField mdpTextField;
    @FXML
    private TextField confirmerMdpTextField;
    @FXML
    private Label erreur ;
    @FXML
    private Label utilisateurLabel ;

    UtilisateurRepository ur = new UtilisateurRepository();

    public void redirectionRetour() throws IOException {
        StartApplication.changeScene("AccueilgestionUtilisateur");
    }
    public void verifierChamps() throws IOException, SQLException {
        Utilisateur utilisateurSelectionnee = ur.recupererUtilisateur() ;

        if(!nomTextField.getText().isEmpty()){
            ur.majNom(utilisateurSelectionnee,nomTextField.getText());
        }
      if(!prenomTextField.getText().isEmpty()){
          ur.majPrenom(utilisateurSelectionnee,prenomTextField.getText());
      }
        if(!emailTextField.getText().isEmpty()){
            ur.majEmail(utilisateurSelectionnee,emailTextField.getText());
        }
        if(!mdpTextField.getText().isEmpty() && mdpTextField.getText().equals(confirmerMdpTextField.getText())){
            ur.majMdp(utilisateurSelectionnee,mdpTextField.getText());
        }
        StartApplication.changeScene("ModifierUtilisateur");

    }
    public void initialize() throws SQLException {
        Utilisateur utilisateurSelectionnee = ur.recupererUtilisateur();
        utilisateurLabel.setText("Gestion "+utilisateurSelectionnee.getPrenom()+" "+utilisateurSelectionnee.getNom());
    }

}
