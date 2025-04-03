package repository;

import database.Database;
import model.Liste;
import model.Tache;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TacheRepository {
    private Connection connexion;

    public TacheRepository() {
        this.connexion = Database.getConnexion();
    }


    public boolean ajouterTache(Tache tache , Liste liste , Type type) throws SQLException {
        String sql = "INSERT INTO tache(nom,etat,ref_liste,ref_type) VALUES(?,?,?,?)";
        PreparedStatement ps = connexion.prepareStatement(sql);
        try {
            ps.setString(1, tache.getNom());
            ps.setInt(2, tache.getEtat());
            ps.setInt(3, tache.getRef_liste());
            ps.setInt(4, tache.getRef_type());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Liste recupererListe() throws SQLException {
        String sql = "SELECT * FROM V_LISTE ";
        int id = 0;
        String nom = "";
        PreparedStatement ps = connexion.prepareStatement(sql);
        Liste liste = null;
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_liste");
                nom = rs.getString("nom");
                liste = new Liste(id, nom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
    public Type recupererType() throws SQLException {
        String sql = "SELECT * FROM V_TYPE ";
        int id = 0;
        String nom = "";
        String code_couleur ="";
        PreparedStatement ps = connexion.prepareStatement(sql);
        Type type = null;
        try{
            ResultSet rs = ps.executeQuery() ;
            if(rs.next()){
                id = rs.getInt("id_type");
                nom = rs.getString("nom");
                code_couleur = rs.getString("code_couleur");
                type = new Type(id, nom, code_couleur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return type;
    }
    public void detruireInfoListe() throws SQLException {
        String sql = "Drop View V_LISTE";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.executeUpdate();
    }
    public void detruireInfoType() throws SQLException {
        String sql = "Drop View V_TYPE";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.executeUpdate();
    }

}
