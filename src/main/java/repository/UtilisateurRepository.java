package repository;

import java.sql.*;
import java.util.ArrayList;

import database.Database ;
import model.Utilisateur;


public class UtilisateurRepository {
    private Connection connexion;

    public UtilisateurRepository() {
        this.connexion = Database.getConnexion();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe,role) VALUES (?, ?, ?, ?,?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getPassword());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    public Utilisateur getUtilisateurParEmail(String email) {

        int idSQL = 0 ;
        String prenomSQL = "";
        String nomSQL = "";
        String emailSQL = "";
        String mdpSQL = "";
        String roleSQL = "";

        Utilisateur utilisateur = null ;

        try {
            String sql = "SELECT * FROM utilisateur WHERE email = ?";
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultatRequete = stmt.executeQuery();
            if(resultatRequete.next()) {
               idSQL = resultatRequete.getInt("id_utilisateur");
               prenomSQL =  resultatRequete.getString("prenom");
               nomSQL =  resultatRequete.getString("nom");
               emailSQL =  resultatRequete.getString("email");
               mdpSQL =  resultatRequete.getString("mot_de_passe");
               roleSQL = resultatRequete.getString("role");
               utilisateur = new Utilisateur(idSQL,nomSQL,prenomSQL,emailSQL,mdpSQL,roleSQL) ;
            }
            resultatRequete.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }

        return utilisateur ;
    }

    public ArrayList<Utilisateur> getTousLesUtilisateurs() throws SQLException {
        String sql = "SELECT * from utilisateur";
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        int id = 0;
        String nom = "";
        String prenom = "";
        String email = "";
        String mdp = "";
        String role = "";
        Utilisateur utilisateur = null;
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet resultatRequete = stmt.executeQuery(sql);
            while (resultatRequete.next()) {
                id = resultatRequete.getInt("id_utilisateur");
                 nom = resultatRequete.getString("nom");
                prenom = resultatRequete.getString("prenom");
                email = resultatRequete.getString("email");
                mdp = resultatRequete.getString("mot_de_passe");
                utilisateur = new Utilisateur(id,nom,prenom,email,mdp,role) ;
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
        return utilisateurs;
    }
    public void supprimerUtilisateurParEmail(Utilisateur utilisateur) {
        String sql = "DELETE FROM utilisateur WHERE email = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getEmail());
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateur set nom = ? , prenom=?,email=?,mdp=?,role=? WHERE email = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1,utilisateur.getNom()) ;
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
}

