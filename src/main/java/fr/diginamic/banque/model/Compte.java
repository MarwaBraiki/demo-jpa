package fr.diginamic.banque.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE") // Discriminator column to differentiate between types
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO", nullable = false, unique = true)
    private String numero;

    @Column(name = "SOLDE", nullable = false)
    private BigDecimal solde;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private BanqueClient client;

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE", nullable = false)
    private Banque banque;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public BanqueClient getClient() {
        return client;
    }

    public void setClient(BanqueClient client) {
        this.client = client;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", client=" + client +
                ", banque=" + banque +
                '}';
    }
}
