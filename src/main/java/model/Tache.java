package model;

public class Tache {
    private String nom ;
    private int etat ;
    private int ref_liste ;
    private int ref_type ;

    public Tache(String nom, int etat, int ref_liste, int ref_type) {
        this.nom = nom ;
        this.etat = etat ;
        this.ref_liste = ref_liste ;
        this.ref_type = ref_type ;
    }
    public String getNom() {
        return nom;
    }
}
