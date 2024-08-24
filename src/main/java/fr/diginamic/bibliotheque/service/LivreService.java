package fr.diginamic.bibliotheque.service;

import fr.diginamic.bibliotheque.model.Livre;
import fr.diginamic.bibliotheque.repository.LivreRepository;

import java.util.Optional;

public class LivreService {

    private LivreRepository livreRepository;

    public LivreService() {
        this.livreRepository = new LivreRepository();
    }

    public Optional<Livre> findLivreById(Integer id) {
        return livreRepository.findById(id);
    }
}
