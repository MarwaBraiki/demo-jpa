package fr.diginamic.banque.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPERATION") // Discriminator column to differentiate between types
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MONTANT", nullable = false)
    private BigDecimal montant;

    @Column(name = "DATE_OPERATION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;

    @ManyToOne
    @JoinColumn(name = "ID_COMPTE", nullable = false)
    private Compte compte;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", montant=" + montant +
                ", dateOperation=" + dateOperation +
                ", compte=" + compte +
                '}';
    }
}
