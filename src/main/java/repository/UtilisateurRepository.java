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
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getPassword());
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
               utilisateur = new Utilisateur(idSQL,nomSQL,prenomSQL,emailSQL,mdpSQL) ;
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
                utilisateur = new Utilisateur(id,nom,prenom,email) ;
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
        return utilisateurs;
    }
    public boolean creerVueUtilisateur(Utilisateur utilisateur){
        String sql = "Create OR REPLACE View V_UTILISATEUR as " +
                "Select * from utilisateur where id_utilisateur = "+utilisateur.getId_utilisateur();
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la requête  " + e.getMessage());
            return false;
        }
    }
    public boolean supprimerUtilisateurParEmail(String email) {
        String sql = "DELETE FROM utilisateur WHERE email = ? ";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate() ;
            return true ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
            return false ;
        }
    }
    public void supprimerUtilisateurParId(String id) {
        String sql = "DELETE FROM utilisateur WHERE id_utilisateur = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }

    public void majNom(Utilisateur utilisateur,String nom) {
        String sql = "UPDATE utilisateur set nom = ? where id_utilisateur = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1,nom); ;
            stmt.setInt(2,utilisateur.getId_utilisateur());
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
    public void majPrenom(Utilisateur utilisateur,String prenom) {
        String sql = "UPDATE utilisateur set prenom = ? where id_utilisateur = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1,prenom); ;
            stmt.setInt(2,utilisateur.getId_utilisateur()); ;
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
    public void majEmail(Utilisateur utilisateur,String email) {
        String sql = "UPDATE utilisateur set email = ? where id_utilisateur = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setInt(2,utilisateur.getId_utilisateur()); ;
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
    public void majMdp(Utilisateur utilisateur,String mdp) {
        String sql = "UPDATE utilisateur set mot_de_passe = ? where id_utilisateur = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1,mdp);
            stmt.setInt(2,utilisateur.getId_utilisateur()); ;
            stmt.executeUpdate() ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }

    public void detruireInfoUtilisateur() throws SQLException {
        String sql = "Drop View V_UTILISATEUR";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.executeUpdate();
    }
   public Utilisateur recupererUtilisateur() throws SQLException {
        String sql = "SELECT * FROM V_UTILISATEUR";
       int idSQL = 0 ;
       String prenomSQL = "";
       String nomSQL = "";
       String emailSQL = "";
       String mdpSQL = "";

       Utilisateur utilisateur = null ;

       try {
           PreparedStatement stmt = connexion.prepareStatement(sql);
           ResultSet resultatRequete = stmt.executeQuery();
           if(resultatRequete.next()) {
               idSQL = resultatRequete.getInt("id_utilisateur");
               prenomSQL =  resultatRequete.getString("prenom");
               nomSQL =  resultatRequete.getString("nom");
               emailSQL =  resultatRequete.getString("email");
               mdpSQL =  resultatRequete.getString("mot_de_passe");
               utilisateur = new Utilisateur(idSQL,nomSQL,prenomSQL,emailSQL,mdpSQL) ;
           }
           resultatRequete.close();
           stmt.close();

       } catch (SQLException e) {
           System.out.println("Erreur lors de la requête  " + e.getMessage());
       }

       return utilisateur ;
   }
   }


