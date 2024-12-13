

public class Compte {
    private int idCompte;
    private String email;
    private String motDePasse;

    // Constructeur
    public Compte(int idCompte, String email, String motDePasse) {
        this.idCompte = idCompte;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters et Setters
    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "idCompte=" + idCompte +
                ", email='" + email + '\'' +
                '}';
    }
}
