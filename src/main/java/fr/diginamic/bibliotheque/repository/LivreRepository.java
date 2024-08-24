package fr.diginamic.bibliotheque.repository;

import fr.diginamic.bibliotheque.model.Livre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.Optional;

public class LivreRepository {

    private EntityManager entityManager;

    public LivreRepository() {
        this.entityManager = Persistence.createEntityManagerFactory("bibliothequePU").createEntityManager();
    }

    public Optional<Livre> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Livre.class, id));
    }
}
