package repository;

import database.Database;
import model.Tache;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TacheRepository {
    private Connection connexion;

    public TacheRepository() {
        this.connexion = Database.getConnexion();
    }

    public boolean ajouterType(Type type) throws SQLException {
        String sql = "INSERT INTO type(nom,code_couleur) VALUES(?,?)";
        PreparedStatement ps = connexion.prepareStatement(sql);
        try {
            ps.setString(1, type.getNom());
            ps.setString(2, type.getCodeCouleur());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ajouterTache(Tache tache) throws SQLException {
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
}
