package fr.diginamic.banque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation {
    // Propriétés spécifiques au Virement si nécessaire

    @Override
    public String toString() {
        return "Virement{" +
                "id=" + getId() +
                ", montant=" + getMontant() +
                ", dateOperation=" + getDateOperation() +
                ", compte=" + getCompte() +
                '}';
    }
}
