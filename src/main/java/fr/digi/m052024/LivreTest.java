package fr.digi.m052024;

import fr.digi.m052024.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LivreTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        try {
            // Create and persist a new book
            em.getTransaction().begin();
            Livre livre = new Livre("Les Misérables", "Victor Hugo");
            em.persist(livre);
            em.getTransaction().commit();

            // Find the book by id
            Livre foundLivre = em.find(Livre.class, livre.getId());
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
