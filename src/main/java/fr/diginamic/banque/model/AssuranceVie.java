package fr.diginamic.banque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ASSURANCE_VIE")
public class AssuranceVie extends Compte {
    // Propriétés spécifiques à AssuranceVie si nécessaire

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                ", client=" + getClient() +
                ", banque=" + getBanque() +
                '}';
    }
}
