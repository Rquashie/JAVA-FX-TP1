package model;

public class Tache {
    private String nom ;
    private int etat ;
    private int ref_liste ;
    private int ref_type ;

    public Tache(String nom, int etat, Liste liste, Type type) {
        this.nom = nom ;
        this.etat = etat ;
        this.ref_liste = liste.getId_liste() ;
        this.ref_type = type.getIdType() ;
    }
    public String getNom() {
        return nom;
    }
    public int getEtat() {
        return etat;
    }
    public int getRef_liste() {
        return ref_liste;
    }
    public int getRef_type() {
        return ref_type;
    }
}
