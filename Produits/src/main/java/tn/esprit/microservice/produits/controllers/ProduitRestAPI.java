package tn.esprit.microservice.produits.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice.produits.Producer.RabbitMQProducer;
import tn.esprit.microservice.produits.entites.Produit;
import tn.esprit.microservice.produits.services.IProduitsService;

import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
@CrossOrigin("*")

public class ProduitRestAPI {
    private RabbitMQProducer rabbitMQProducer;

    @Autowired
    public ProduitRestAPI(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @Autowired
    private IProduitsService produitsService;

    @GetMapping
    public List<Produit> getAllProducts() {
        rabbitMQProducer.sendMessage("All products fetched");
        return produitsService.getAllProduits();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        rabbitMQProducer.sendMessage("PRODUCT CREATED");
        return new ResponseEntity<>(produitsService.addProduit(produit), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") int id,
                                                   @RequestBody Produit produit)
    {         rabbitMQProducer.sendMessage("PRODUCT UPDATED");

        return new ResponseEntity<>(produitsService.updateProduit(id, produit),
            HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProduit(@PathVariable(value = "id") int id)
    {     rabbitMQProducer.sendMessage("PRODUCT deleted");

        return new ResponseEntity<>(produitsService.deleteProduit(id), HttpStatus.OK);
    }

}


