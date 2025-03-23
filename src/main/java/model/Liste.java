package model;

public class Liste {
    private int id_liste;
    private String nom ;

    public Liste(String nom) {
        this.nom = nom;
    }
    public Liste(int id_liste , String nom) {
        this.id_liste = id_liste;
        this.nom = nom;
    }
    public int getId_liste() {
        return this.id_liste;
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
