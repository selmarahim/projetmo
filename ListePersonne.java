import java.util.ArrayList;
import java.util.List;

public class ListePersonne {
    private List<Personne> personnes;

    // Constructeur
    public ListePersonne() {
        this.personnes = new ArrayList<>();
    }

    // Ajouter une personne à la liste
    public void ajouterPersonne(Personne personne) {
        if (rechercherPersonne(personne.getId()) == null) {
            this.personnes.add(personne);
            System.out.println("Personne ajoutée : " + personne.getNom() + " " + personne.getPrenom());
        } else {
            System.out.println("Une personne avec cet ID existe déjà.");
        }
    }

    // Rechercher une personne par ID
    public Personne rechercherPersonne(int id) {
        for (Personne personne : personnes) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return null;
    }

    // Afficher toutes les personnes
    public void afficherToutesLesPersonnes() {
        if (personnes.isEmpty()) {
            System.out.println("Aucune personne enregistrée.");
        } else {
            System.out.println("\nListe des personnes :");
            for (Personne personne : personnes) {
                System.out.println("- ID : " + personne.getId() +
                        ", Nom : " + personne.getNom() +
                        ", Prénom : " + personne.getPrenom() +
                        ", Email : " + personne.getEmail());
            }
        }
    }
}
