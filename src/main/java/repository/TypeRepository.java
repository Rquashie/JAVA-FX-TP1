package repository;

import database.Database;
import model.Liste;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeRepository {
    private Connection connexion;

    public TypeRepository() {
        this.connexion = Database.getConnexion();
    }

    public int ajouterType(Type type) throws SQLException {
        String sql = "INSERT INTO type(nom,code_couleur) VALUES(?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, type.getNom());
            ps.setString(2, type.getCodeCouleur());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
    }

    public boolean creerVuesType(int id) {
        String sql = "Create View V_TYPE as " +
                "Select * from type where id_type = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la requête  " + e.getMessage());
            return false;
        }
    }

    public Type getTypeParId(int id ) throws SQLException {
        int idSQL = 0;
        String codeCouleur = "";
        String nomSQL = "";

        String sql = "SELECT * FROM type ORDER BY id_type DESC LIMIT 1";
        Type type = null ;
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idSQL = rs.getInt("id_type");
                nomSQL = rs.getString("nom");
                codeCouleur = rs.getString("code_couleur");
                type= new Type(idSQL, nomSQL,codeCouleur);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
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

    public void detruireInfoType() throws SQLException {
        String sql = "Drop View V_TYPE";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.executeUpdate();
    }

}
