package tn.esprit.microservice.produits.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.produits.entites.Produit;
import tn.esprit.microservice.produits.repositories.ProduitRepo;

import java.util.List;

@Service
@Slf4j
public class ProduitsIMP implements IProduitsService {
    @Autowired
    private ProduitRepo produitRepo;
public List<Produit> getAllProduits(){
    return produitRepo.findAll();
}
    public Produit addProduit(Produit produit) {
        return produitRepo.save(produit);
    }
    public Produit updateProduit(int id, Produit newProduit)
    { if (produitRepo.findById(id).isPresent()) {

        Produit existingProduit = produitRepo.findById(id).get();
        existingProduit.setNom(newProduit.getNom());
        existingProduit.setDescription(newProduit.getDescription());
        existingProduit.setCategorie(newProduit.getCategorie());
        existingProduit.setPrixdépart(newProduit.getPrixdépart());
        existingProduit.setPrixAchatImmediat(newProduit.getPrixAchatImmediat());
        existingProduit.setStatut(newProduit.getStatut());
        existingProduit.setDateDebutEnchere(newProduit.getDateDebutEnchere());
        existingProduit.setDateFinEnchere(newProduit.getDateFinEnchere());
        existingProduit.setEtatProduit(newProduit.getEtatProduit());
        return produitRepo.save(existingProduit);
    } else
        return null;
    }

    public String deleteProduit(int id) {
        if (produitRepo.findById(id).isPresent()) { produitRepo.deleteById(id);
            return "Produit supprimé";
        } else
            return "Produit non supprimé";
    }
}


