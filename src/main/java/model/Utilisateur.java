package model;

public class Utilisateur {
    private int id;
    private String nomField;
    private String prenomField;
   private String emailField ;
   private String passwordField ;
   private String role ;

    public Utilisateur(String email, String mdp) {
        this.emailField = email;
        this.passwordField = mdp;

    }
    public Utilisateur(String nom, String prenom, String email, String mdp,String role) {
        this.nomField = nom;
        this.prenomField = prenom;
        this.emailField = email;
        this.passwordField = mdp;
        this.role = role;
    }
    public Utilisateur(int id, String nom, String prenom, String email, String mdp,String role) {
        this.id = id;
        this.nomField = nom;
        this.prenomField = prenom;
        this.emailField = email;
        this.passwordField = mdp;
        this.role = role;
    }



    public int getId() {
        return this.id;
    }
    public String getNom() {
        return this.nomField;
    }
    public void setNom(String nom) {
        this.nomField = nom;
    }
    public String getPrenom() {
        return this.prenomField;
    }
    public void setPrenom(String prenom) {
        this.prenomField = prenom;
    }
    public String getEmail() {
        return this.emailField;
    }
    public void setEmail(String email) {
        this.emailField = email;
    }
    public String getMdp() {
        return this.passwordField;
    }
    public String getRole() {
        return this.role;
    }

    public String toString() {
        return "Nom : "+this.nomField+"\nPrenom : "+this.prenomField+"\nEmail : "+this.emailField+"\nMdp : "+this.passwordField+"\nRole : "+this.role;
    }
}
