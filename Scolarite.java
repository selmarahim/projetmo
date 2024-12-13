public class Scolarite {
    private String departement;

    public Scolarite(String departement) {
        this.departement = departement;
    }

    public Personne creerPersonne(int id, String nom, String prenom, String email, Compte compte, Role role) {
        // on creer une nouvelle personne
        Personne personne = new Personne(id, nom, prenom, email);

        // on associe un compte et un roole a la personne qu'on a creer
        personne.setCompte(compte);
        personne.addRole(role);

        // Retourne la personne créée
        return personne;
    }

    @Override
    public String toString() {
        return "Scolarite{" +
                "departement='" + departement + '\'' +
                '}';
    }
}
