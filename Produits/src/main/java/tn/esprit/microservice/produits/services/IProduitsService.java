package tn.esprit.microservice.produits.services;

import tn.esprit.microservice.produits.entites.Produit;

import java.util.List;

public interface IProduitsService {
    public List<Produit> getAllProduits();
    public Produit addProduit(Produit produit);
    public Produit updateProduit(int id, Produit newProduit);
    public String deleteProduit(int id);
}
