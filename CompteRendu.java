import java.util.ArrayList;
import java.util.List;

public class CompteRendu {
    private String auteur;
    private String contenu;
    private List<Commentaire> commentaires;

    // Constructeur
    public CompteRendu(String auteur, String contenu) {
        this.auteur = auteur;
        this.contenu = contenu;
        this.commentaires = new ArrayList<>();
    }

    // Getter pour le contenu
    public String getContenu() {
        return contenu;
    }

    // Setter pour le contenu
    public void setContenu(String contenu) {
        this.contenu = contenu;
        System.out.println("Le contenu du compte rendu a été mis à jour.");
    }

    // Ajouter un commentaire
    public void ajouterCommentaire(Commentaire commentaire) {
        this.commentaires.add(commentaire);
        System.out.println("Commentaire ajouté par : " + commentaire.getAuteur());
    }

    // Afficher les commentaires
    public void afficherCommentaires() {
        if (commentaires.isEmpty()) {
            System.out.println("Aucun commentaire pour ce compte rendu.");
        } else {
            System.out.println("Commentaires :");
            for (Commentaire commentaire : commentaires) {
                System.out.println("- " + commentaire.getAuteur() + ": " + commentaire.getTexte());
            }
        }
    }

    @Override
    public String toString() {
        return "CompteRendu{" +
                "auteur='" + auteur + '\'' +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}
