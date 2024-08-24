package fr.diginamic.banque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LIVRET_A")
public class LivretA extends Compte {
    // Propriétés spécifiques à LivretA si nécessaire

    @Override
    public String toString() {
        return "LivretA{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                ", client=" + getClient() +
                ", banque=" + getBanque() +
                '}';
    }
}
