package repository;

import database.Database;
import model.Liste;
import model.Tache;
import model.Type;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Tache> getToutesLesTacheListe(Utilisateur utilisateur , Liste liste) throws SQLException {
        String sql = "SELECT l.nom , t.nom , t.etat , u.prenom , u.nom from utilisateur u " +
                "inner join utilisateur_liste ul on u.id_utilisateur=ul.ref_utilisateur" +
                "inner join liste l on l.id_liste=ul.ref_liste" +
                "inner join tache t on t.ref_liste=l.id_liste" +
                "where id_liste = ? and id_utilisateur = ?";
        ArrayList<Tache> lesTaches = new ArrayList<>();
        int id = 0;
        String nomListe = null;
        String nomTache = "";
        String nomUtilisateur = null;
        int etat = 0;
        Tache tache = null;
        String prenomUtilisateur = null ;
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet resultatRequete = stmt.executeQuery();
            stmt.setInt(1, liste.getId_liste());
            stmt.setInt(2, utilisateur.getId_utilisateur());
            while (resultatRequete.next()) {
                nomListe = liste.getNom();
                nomTache = resultatRequete.getString("nom");
                etat = resultatRequete.getInt("etat");
                prenomUtilisateur = utilisateur.getPrenom();
                nomUtilisateur = utilisateur.getNom();
                tache = new Tache(nomListe,nomTache,etat,nomUtilisateur,prenomUtilisateur)
                ;
                lesTaches.add(tache);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesTaches;
    }





}
