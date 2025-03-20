package model;

public class Type {
    private String nom ;
    private String codeCouleur ;

    public Type(String nom, String codeCouleur) {
        this.nom = nom;
        this.codeCouleur = codeCouleur;
    }
    public String getNom() {
        return this.nom;
    }
    public String getCodeCouleur() {
        return this.codeCouleur;
    }
}
