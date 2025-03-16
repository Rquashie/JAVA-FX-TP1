package appli.accueil;

import model.Utilisateur;
import session.SessionUtilisateur;

public class MainController {
    public static void main(String[] args) {
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel != null) {
            System.out.println("Utilisateur connecté : " + utilisateurActuel.getNom());
        }
    }
}
