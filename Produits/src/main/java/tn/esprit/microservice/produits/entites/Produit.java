package tn.esprit.microservice.produits.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Produit implements Serializable {
    @Id
    private  int id;
    private String nom;
    private String description;
    private Categorie categorie; // Catégorie du produit
    private long Prixdépart; // Prix de départ de l'enchère
    private long prixAchatImmediat; // Prix d'achat immédiat (optionnel)
    private Statut statut;

    private LocalDateTime dateDebutEnchere; // Date et heure de début d'enchère


    private LocalDateTime dateFinEnchere; // Date et heure de fin d'enchère
    private EtatProduit etatProduit;

}
