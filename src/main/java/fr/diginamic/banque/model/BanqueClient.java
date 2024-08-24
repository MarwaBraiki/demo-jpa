package fr.diginamic.banque.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BANQUE_CLIENT") // Nom de la table dans la base de données bancaire
public class BanqueClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "PRENOM", nullable = false)
    private String prenom;

    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    private Set<AssuranceVie> assurancesVie;

    @OneToMany(mappedBy = "client")
    private Set<LivretA> livretsA;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<AssuranceVie> getAssurancesVie() {
        return assurancesVie;
    }

    public void setAssurancesVie(Set<AssuranceVie> assurancesVie) {
        this.assurancesVie = assurancesVie;
    }

    public Set<LivretA> getLivretsA() {
        return livretsA;
    }

    public void setLivretsA(Set<LivretA> livretsA) {
        this.livretsA = livretsA;
    }

    @Override
    public String toString() {
        return "BanqueClient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                '}';
    }
}
