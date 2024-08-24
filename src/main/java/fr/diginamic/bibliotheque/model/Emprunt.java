package fr.diginamic.bibliotheque.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE_DEBUT", nullable = false)
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "EMPRUNT_LIVRE",
            joinColumns = @JoinColumn(name = "EMPRUNT_ID"),
            inverseJoinColumns = @JoinColumn(name = "LIVRE_ID")
    )
    private List<Livre> livres;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", client=" + client +
                ", livres=" + livres +
                '}';
    }
}
