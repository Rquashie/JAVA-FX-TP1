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
        this.connexion = Database.getConnexion() ;
    }
    public boolean ajouterListe(Liste nomprojet) {
        String sql = "INSERT INTO liste(nom) VALUES (?) ";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, nomprojet.getNom());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la liste : " + e.getMessage());
            return false ;
        }
    }
    public int recupererClePrimaireListe(String nom) throws SQLException {
        String sql = "SELECT id FROM liste where nom = ? ";
        int id = 0;
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_liste");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id ;
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
        return liste ;
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
                liste = new Liste(id,nom) ;
                listes.add(liste);
            }
            if(listes.isEmpty()){
                System.out.println("Aucune liste a été créee");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listes ;
    }
    public  void associerListeUtilisateur(int ref_utilisateur,int ref_liste) throws SQLException {
        String sql = "INSERT into utilisateur_liste(ref_utilisateur,ref_liste) VALUES (?,?)";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setInt(1, ref_utilisateur);
            stmt.setInt(2, ref_liste);
            stmt.executeUpdate();
    }
        catch (SQLException e) {
        e.printStackTrace();
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
    public void creerVuesListe(Liste liste) {
        String sql = "Create View laListe as " +
                "Select * from liste where id_liste = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setInt(1,liste.getId_liste());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la requête  " + e.getMessage());
        }
    }
}
