package fr.diginamic.banque;

import fr.diginamic.banque.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date; // Utiliser java.util.Date

public class BanqueApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banquePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            // Démarrer la transaction
            transaction.begin();

            // Rechercher si la banque "Banque Centrale" existe déjà
            Banque banque = em.createQuery(
                            "SELECT b FROM Banque b WHERE b.nom = :nom", Banque.class)
                    .setParameter("nom", "Banque Centrale")
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            // Si la banque n'existe pas, la créer
            if (banque == null) {
                banque = new Banque();
                banque.setNom("Banque Centrale");
                em.persist(banque);
            }

            // Créer ou récupérer le client
            BanqueClient client = em.createQuery(
                            "SELECT c FROM BanqueClient c WHERE c.nom = :nom AND c.prenom = :prenom", BanqueClient.class)
                    .setParameter("nom", "Dupont")
                    .setParameter("prenom", "Jean")
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (client == null) {
                client = new BanqueClient();
                client.setNom("Dupont");
                client.setPrenom("Jean");
                Adresse adresse = new Adresse();
                adresse.setRue("1 rue de la République");
                adresse.setVille("Paris");
                adresse.setCodePostal("75001");
                client.setAdresse(adresse);
                em.persist(client);
            }

            // Créer un compte AssuranceVie pour le client
            AssuranceVie compteAssuranceVie = new AssuranceVie();
            compteAssuranceVie.setNumero("123456789");
            compteAssuranceVie.setSolde(BigDecimal.valueOf(2000.00));
            compteAssuranceVie.setBanque(banque); // Utilise la banque récupérée ou créée
            compteAssuranceVie.setClient(client);
            em.persist(compteAssuranceVie);

            // Créer un compte LivretA pour le client
            LivretA compteLivretA = new LivretA();
            compteLivretA.setNumero("987654321");
            compteLivretA.setSolde(BigDecimal.valueOf(1500.00));
            compteLivretA.setBanque(banque); // Utilise la banque récupérée ou créée
            compteLivretA.setClient(client);
            em.persist(compteLivretA);

            // Créer une opération de type Virement
            Virement virement = new Virement();
            virement.setMontant(BigDecimal.valueOf(500.00));
            virement.setDateOperation(new Date());
            virement.setCompte(compteAssuranceVie);
            em.persist(virement);

            // Créer une opération de type Opération
            Operation operation = new Operation();
            operation.setMontant(BigDecimal.valueOf(200.00));
            operation.setDateOperation(new Date());
            operation.setCompte(compteLivretA);
            em.persist(operation);

            // Commit de la transaction
            transaction.commit();

            // Vérifier les IDs insérés
            System.out.println("ID du compte AssuranceVie inséré: " + compteAssuranceVie.getId());
            System.out.println("ID du compte LivretA inséré: " + compteLivretA.getId());
            System.out.println("ID de l'opération de type Virement insérée: " + virement.getId());
            System.out.println("ID de l'opération de type Opération insérée: " + operation.getId());

        } catch (Exception e) {
            // En cas d'erreur, rollback de la transaction
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Fermer l'EntityManager
            em.close();
            emf.close();
        }
    }

}
