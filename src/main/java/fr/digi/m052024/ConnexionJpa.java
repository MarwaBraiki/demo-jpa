package fr.digi.m052024;

import fr.digi.m052024.entities.Client;
import fr.digi.m052024.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Create and persist a new client
            Client newClient = new Client("Doe", "John");
            em.persist(newClient);

            // Create and persist a new book
            Livre newLivre = new Livre("Les Misérables", "Victor Hugo");
            em.persist(newLivre);

            em.getTransaction().commit();

            // Find the book by id
            Livre foundLivre = em.find(Livre.class, newLivre.getId());
            if (foundLivre != null) {
                System.out.println("Livre trouvé : " + foundLivre);
            } else {
                System.out.println("Livre non trouvé.");
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
