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
    private TextField confirmerMdppTextField;
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
            erreur.setText("Nom modifié");
        }
      if(!prenomTextField.getText().isEmpty()){
          ur.majPrenom(utilisateurSelectionnee,prenomTextField.getText());
          erreur.setText("Prenom modifié");
      }
        if(!emailTextField.getText().isEmpty()){
            ur.majEmail(utilisateurSelectionnee,emailTextField.getText());
            erreur.setText("email modifié");
        }
        if(!mdpTextField.getText().isEmpty() && mdpTextField.getText().equals(confirmerMdppTextField.getText())){
            ur.majMdp(utilisateurSelectionnee,mdpTextField.getText());
        }

    }
    public void initialize() throws SQLException {
        Utilisateur utilisateurSelectionnee = ur.recupererUtilisateur();
        utilisateurLabel.setText("Gestion "+utilisateurSelectionnee.getPrenom()+" "+utilisateurSelectionnee.getNom());
    }

}
