package model;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
   private String email ;
   private String mdp ;
   private String role ;
    public Utilisateur(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;

    }
    public Utilisateur(String nom, String prenom, String email, String mdp,String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }
    public Utilisateur(int id, String nom, String prenom, String email, String mdp,String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }
    public int getId() {
        return this.id;
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return this.mdp;
    }
    public String getRole() {
        return this.role;
    }

    public String toString() {
        return "Nom : "+this.nom+"\nPrenom : "+this.prenom+"\nEmail : "+this.email+"\nMdp : "+this.mdp;
    }
}
