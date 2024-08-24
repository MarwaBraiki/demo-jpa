package fr.diginamic.bibliotheque.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliothequePU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
