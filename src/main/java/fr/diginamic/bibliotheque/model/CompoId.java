package fr.diginamic.bibliotheque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompoId implements Serializable {

    @Column(name = "ID_LIV")
    private Long idLivre;

    @Column(name = "ID_EMP")
    private Long idEmprunt;

    public CompoId() {}

    public CompoId(Long idLivre, Long idEmprunt) {
        this.idLivre = idLivre;
        this.idEmprunt = idEmprunt;
    }

    // Getters and Setters
    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }

    public Long getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(Long idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompoId compoId = (CompoId) o;
        return Objects.equals(idLivre, compoId.idLivre) &&
                Objects.equals(idEmprunt, compoId.idEmprunt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLivre, idEmprunt);
    }
}
