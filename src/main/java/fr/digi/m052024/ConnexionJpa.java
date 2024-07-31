package fr.digi.m052024;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        // Création d'une instance d'EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");

        // Création d'une instance d'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Vérification de la connexion
        System.out.println("Connexion à la base de données réussie !");

        // Fermeture des instances
        entityManager.close();
        entityManagerFactory.close();
    }
}
