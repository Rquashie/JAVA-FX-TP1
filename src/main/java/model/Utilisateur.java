package model;

public class Utilisateur {
    private int id_utilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String password;

    public Utilisateur() {
    }

    public Utilisateur(String email , String password) {
         this.email = email;
         this.password = password;

    }
    public Utilisateur( String nom, String prenom, String email, String password) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(int id_utilisateur, String nom, String prenom, String email, String password) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        
    }
}


