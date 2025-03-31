package model;

public class Type {
    private int idType ;
    private String nom ;
    private String codeCouleur ;

    public Type(String nom, String codeCouleur) {
        this.nom = nom;
        this.codeCouleur = codeCouleur;
    }
    public Type(int idType,String nom , String codeCouleur){
        this.idType = idType;
        this.nom = nom;
        this.codeCouleur = codeCouleur;
    }
    public String getNom() {
        return this.nom;
    }
    public String getCodeCouleur() {
        return this.codeCouleur;
    }
    public int getIdType() {
        return this.idType;
    }
}
