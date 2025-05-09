package repository;

import database.Database;
import model.Liste;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeRepository {
    private Connection connexion;

    public ListeRepository() {
        this.connexion = Database.getConnexion();
    }

    public boolean ajouterListe(Liste liste) {
        String sql = "INSERT INTO liste(nom) VALUES (?) ";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, liste.getNom());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la liste : " + e.getMessage());
            return false;
        }
    }

    public Liste getListe(Liste liste) {
        int idSQL = 0;
        String nomSQL = "";

        String sql = "SELECT * FROM liste WHERE id = ? ";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setInt(1, liste.getId_liste());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idSQL = rs.getInt("id_liste");
                nomSQL = rs.getString("nom");
                liste = new Liste(idSQL, nomSQL);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Liste> getToutesLesListes() {
        String sql = "SELECT * from liste";
        ArrayList<Liste> listes = new ArrayList<>();
        int id = 0;
        String nom = "";
        Liste liste = null;
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet resultatRequete = stmt.executeQuery();
            while (resultatRequete.next()) {
                id = resultatRequete.getInt("id_liste");
                nom = resultatRequete.getString("nom");
                liste = new Liste(id, nom);
                listes.add(liste);
            }
            if (listes.isEmpty()) {
                System.out.println("Aucune liste a été créee");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listes;
    }

    public void associerListeUtilisateur(int ref_utilisateur, int ref_liste) throws SQLException {
        String sql = "INSERT into utilisateur_liste(ref_utilisateur,ref_liste) VALUES (?,?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setInt(1, ref_utilisateur);
            stmt.setInt(2, ref_liste);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }

    public boolean creerVuesListe(Liste liste) {
        String sql = "Create OR REPLACE View V_LISTE as " +
                "Select * from liste where id_liste = "+liste.getId_liste();
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
    public boolean tableExiste(String nomTable){
        String sql = "SELECT count(*) FROM information_schema.tables "+
                "WHERE table_name = ? ;" ;
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1,nomTable);
            stmt.executeQuery() ;
            return true ;

        } catch (SQLException e) {
            e.printStackTrace();
            return false ;
        }
    }

    public Liste recupererInfoListe() throws SQLException {
        int id = 0;
        String nom ="";
        Liste liste = null ;
        String sql = "Select * from V_Liste ";
        PreparedStatement stmt = connexion.prepareStatement(sql);
        ResultSet resultatRequete = stmt.executeQuery();
        if (resultatRequete.next()) {
            id = resultatRequete.getInt("id_liste");
            nom = resultatRequete.getString("nom");
            liste =  new Liste(id, nom);
        }
        return liste;
    }
    public void detruireInfoListe() throws SQLException {
        String sql = "Drop View V_LISTE";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.executeUpdate();
    }
}