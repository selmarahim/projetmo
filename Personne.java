
import java.util.ArrayList;
import java.util.List;


public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private List<Role> roles; // Liste des roles associés a la personne
    private Compte compte;    // Compte unique de personne
    private List<CompteRendu> comptesRendus;

    // Constructeur
    public Personne(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.roles = new ArrayList<>();
        this.comptesRendus = new ArrayList<>();
    }

      // Méthode pour rédiger un compte rendu
      public void redigerCompteRendu(String contenu) {
        CompteRendu compteRendu = new CompteRendu(this.nom + " " + this.prenom, contenu);
        comptesRendus.add(compteRendu); // Ajoute le compte rendu à la liste
        System.out.println("Compte rendu rédigé avec succès : " + compteRendu);
    }

    // Méthode pour afficher tous les comptes rendus
    public void afficherComptesRendus() {
        System.out.println("Comptes rendus rédigés par " + this.nom + " " + this.prenom + ":");
        for (CompteRendu cr : comptesRendus) {
            System.out.println(cr);
        }
    }
    public List<CompteRendu> getComptesRendus() {
        return comptesRendus;
    }
    
    public void ajouterRole(Role role) {
        if (!this.roles.contains(role)) { // Vérifie que le rôle n'est pas déjà dans la liste
            this.roles.add(role);
            System.out.println("Rôle ajouté avec succès : " + role);
        } else {
            System.out.println("Le rôle existe déjà : " + role);
        }
    }
    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
