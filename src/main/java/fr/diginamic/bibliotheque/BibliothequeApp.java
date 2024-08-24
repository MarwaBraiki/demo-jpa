package fr.diginamic.bibliotheque;

import fr.diginamic.bibliotheque.model.Client;
import fr.diginamic.bibliotheque.model.Emprunt;
import fr.diginamic.bibliotheque.model.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class BibliothequeApp {

    public static void main(String[] args) {
        // Créer une instance d'EntityManagerFactory à partir de la configuration persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliothequePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            // Démarrer la transaction
            transaction.begin();

            // Créer un nouvel objet Livre
            Livre livre = new Livre();
            livre.setTitre("Le Petit Prince");
            livre.setAuteur("Antoine de Saint-Exupéry");

            // Persister l'objet Livre
            em.persist(livre);
            System.out.println("Livre persisté avec ID: " + livre.getId());

            // Rechercher un Livre par ID
            Livre foundLivre = em.find(Livre.class, livre.getId());
            System.out.println("Livre trouvé: " + foundLivre.getTitre() + ", " + foundLivre.getAuteur());

            // Ajouter les tests
            testFindEmpruntById(em, 1); // Remplacez 1 par l'ID de l'emprunt souhaité
            testFindEmpruntsByClientId(em, 1); // Remplacez 1 par l'ID du client souhaité

            // Commit de la transaction
            transaction.commit();
        } catch (Exception e) {
            // En cas d'erreur, rollback de la transaction
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Fermer l'EntityManager
            em.close();
            emf.close();
        }
    }

    private static void testFindEmpruntById(EntityManager em, Integer empruntId) {
        Emprunt emprunt = em.find(Emprunt.class, empruntId);

        if (emprunt != null) {
            System.out.println("Emprunt ID: " + emprunt.getId());
            System.out.println("Date Début: " + emprunt.getDateDebut());
            System.out.println("Date Fin: " + emprunt.getDateFin());

            System.out.println("Livres associés:");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println(" - " + livre.getTitre() + " par " + livre.getAuteur());
            }
        } else {
            System.out.println("Emprunt non trouvé.");
        }
    }

    private static void testFindEmpruntsByClientId(EntityManager em, Integer clientId) {
        Client client = em.find(Client.class, clientId);

        if (client != null) {
            List<Emprunt> emprunts = client.getEmprunts();

            System.out.println("Emprunts du client " + client.getNom() + " " + client.getPrenom() + ":");
            for (Emprunt emprunt : emprunts) {
                System.out.println(" - Emprunt ID: " + emprunt.getId());
                System.out.println("   Date Début: " + emprunt.getDateDebut());
                System.out.println("   Date Fin: " + emprunt.getDateFin());
            }
        } else {
            System.out.println("Client non trouvé.");
        }
    }
}
