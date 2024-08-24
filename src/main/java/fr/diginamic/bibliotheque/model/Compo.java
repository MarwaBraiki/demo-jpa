package fr.diginamic.bibliotheque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPO")
public class Compo {

    @EmbeddedId
    private CompoId id;

    @ManyToOne
    @MapsId("idLivre")
    @JoinColumn(name = "ID_LIV")
    private Livre livre;

    @ManyToOne
    @MapsId("idEmprunt")
    @JoinColumn(name = "ID_EMP")
    private Emprunt emprunt;

    // Getters and Setters
    public CompoId getId() {
        return id;
    }

    public void setId(CompoId id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }
}
