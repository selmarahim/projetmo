import java.util.Scanner;

public class Interface {
    private Scanner scanner;
    private ListePersonne listePersonnes;

    public Interface() {
        this.scanner = new Scanner(System.in);
        this.listePersonnes = new ListePersonne();
    }

    // Menu principal
    public void menuPrincipal() {
        int choix;
        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Ajouter une personne");
            System.out.println("2. Afficher toutes les personnes");
            System.out.println("3. Rédiger un compte rendu");
            System.out.println("4. Commenter un compte rendu");
            System.out.println("5. Modifier un compte rendu");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1 -> ajouterPersonne();
                case 2 -> afficherPersonnes();
                case 3 -> redigerCompteRendu();
                case 4 -> commenterCompteRendu();
                case 5 -> modifierCompteRendu();
                case 6 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);
    }

    // Ajouter une personne
    private void ajouterPersonne() {
        System.out.print("Entrez l'ID : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();

        System.out.print("Entrez le rôle (Étudiant, Tuteur Universitaire, Tuteur Entreprise) : ");
        String roleNom = scanner.nextLine();

        Role role = new Role(id, roleNom);
        Personne personne = new Personne(id, nom, prenom, email);
        personne.ajouterRole(role);
        listePersonnes.ajouterPersonne(personne);
        System.out.println("Personne ajoutée avec succès.");
    }

    // Afficher toutes les personnes
    private void afficherPersonnes() {
        listePersonnes.afficherToutesLesPersonnes();
    }

    // Rédiger un compte rendu
    private void redigerCompteRendu() {
        System.out.print("Entrez l'ID de la personne : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Personne personne = listePersonnes.rechercherPersonne(id);
        if (personne != null) {
            System.out.print("Entrez le contenu du compte rendu : ");
            String contenu = scanner.nextLine();
            personne.redigerCompteRendu(contenu);
        } else {
            System.out.println("Personne introuvable.");
        }
    }

    // Commenter un compte rendu
    private void commenterCompteRendu() {
        System.out.print("Entrez l'ID du responsable entreprise : ");
        int idResponsable = scanner.nextInt();
        scanner.nextLine();

        Personne responsable = listePersonnes.rechercherPersonne(idResponsable);
        if (responsable == null) {
            System.out.println("Responsable introuvable.");
            return;
        }

        System.out.print("Entrez l'ID de l'auteur du compte rendu : ");
        int idAuteur = scanner.nextInt();
        scanner.nextLine(); 

        Personne auteur = listePersonnes.rechercherPersonne(idAuteur);
        if (auteur == null) {
            System.out.println("Auteur introuvable.");
            return;
        }

        if (auteur.getComptesRendus().isEmpty()) {
            System.out.println("Aucun compte rendu trouvé pour cette personne.");
            return;
        }

        System.out.println("Comptes rendus disponibles :");
        for (int i = 0; i < auteur.getComptesRendus().size(); i++) {
            System.out.println((i + 1) + ". " + auteur.getComptesRendus().get(i));
        }
        System.out.print("Choisissez un compte rendu à commenter (numéro) : ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index >= 0 && index < auteur.getComptesRendus().size()) {
            CompteRendu compteRendu = auteur.getComptesRendus().get(index);
            System.out.print("Entrez le commentaire : ");
            String contenuCommentaire = scanner.nextLine();

            Commentaire commentaire = new Commentaire(
                    responsable.getNom() + " " + responsable.getPrenom(),
                    contenuCommentaire
            );
            compteRendu.ajouterCommentaire(commentaire);
            System.out.println("Commentaire ajouté avec succès.");
        } else {
            System.out.println("Choix invalide.");
        }
    }

    // Modifier un compte rendu
    private void modifierCompteRendu() {
        System.out.print("Entrez l'ID du tuteur : ");
        int idTuteur = scanner.nextInt();
        scanner.nextLine(); 

        Personne tuteur = listePersonnes.rechercherPersonne(idTuteur);
        if (tuteur == null) {
            System.out.println("Tuteur introuvable.");
            return;
        }

        if (tuteur.getComptesRendus().isEmpty()) {
            System.out.println("Aucun compte rendu trouvé pour cette personne.");
            return;
        }

        System.out.println("Comptes rendus disponibles :");
        for (int i = 0; i < tuteur.getComptesRendus().size(); i++) {
            System.out.println((i + 1) + ". " + tuteur.getComptesRendus().get(i));
        }
        System.out.print("Choisissez un compte rendu à modifier (numéro) : ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index >= 0 && index < tuteur.getComptesRendus().size()) {
            System.out.print("Entrez le nouveau contenu : ");
            String nouveauContenu = scanner.nextLine();
            tuteur.getComptesRendus().get(index).setContenu(nouveauContenu);
            System.out.println("Compte rendu modifié avec succès.");
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
