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
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
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

        String prenomSQL = "";
        String nomSQL = "";
        String mdpSQL = "";
        String roleSQL = "";
        Utilisateur utilisateur = null ;

        try {
            String sql = "SELECT * FROM utilisateur WHERE email = ?";
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultatRequete = stmt.executeQuery();
            if(resultatRequete.next()) {
               prenomSQL =  resultatRequete.getString("prenom");
               nomSQL =  resultatRequete.getString("nom");
               mdpSQL =  resultatRequete.getString("mdp");
               roleSQL = resultatRequete.getString("role");
               utilisateur = new Utilisateur(nomSQL,prenomSQL,email,mdpSQL,roleSQL) ;
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
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet resultatRequete = stmt.executeQuery(sql);
            while (resultatRequete.next()) {
                utilisateurs.add(resultatRequete.getObject(1, Utilisateur.class));
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

