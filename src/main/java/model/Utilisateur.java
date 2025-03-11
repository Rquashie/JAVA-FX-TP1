package model;

public class Utilisateur {
    private int id_utilisateur;
    private String nom ;
    private String prenom ;
    private String email ;
    private String password ;

    public Utilisateur(int id_utilisateur , String nom , String prenom , String email , String password) {
        this.id_utilisateur = id_utilisateur ;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public String getEmail() {
        return this.email;
    }

}
