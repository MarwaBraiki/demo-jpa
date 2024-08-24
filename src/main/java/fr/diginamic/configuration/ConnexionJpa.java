package fr.diginamic.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {
        // Créer une instance d'EntityManagerFactory pour l'unité de persistance "comptaPU"
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("comptaPU");
            em = emf.createEntityManager();

            // Vérifier la connexion en affichant un message de succès
            System.out.println("Connexion réussie !");
        } catch (Exception e) {
            // Gérer les exceptions ici, par exemple, en affichant un message d'erreur
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
