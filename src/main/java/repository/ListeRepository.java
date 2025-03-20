package repository;

import database.Database;
import model.Liste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListeRepository {
    private Connection connexion;

    public ListeRepository() {
        this.connexion = Database.getConnexion() ;
    }
    public void ajouterProjet(Liste nomprojet) {
        String sql = "INSERT INTO liste(nom) VALUES (?) ";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, nomprojet.getNom());
            System.out.println("Projet ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la liste : " + e.getMessage());
        }
    }
}
