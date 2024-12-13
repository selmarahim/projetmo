import java.util.Date;

public class Commentaire {
    private String auteur;
    private String texte;
    private Date date;

    // Constructeur
    public Commentaire(String auteur, String texte) {
        this.auteur = auteur;
        this.texte = texte;
        this.date = new Date(); // Date actuelle
    }

    // Getter pour auteur
    public String getAuteur() {
        return auteur;
    }

    // Getter pour texte
    public String getTexte() {
        return texte;
    }

    // Getter pour date
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "auteur='" + auteur + '\'' +
                ", texte='" + texte + '\'' +
                ", date=" + date +
                '}';
    }
}
