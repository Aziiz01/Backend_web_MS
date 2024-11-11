package com.esprit.encheremicroservice.controllers;

import com.esprit.encheremicroservice.entities.Enchere;
import com.esprit.encheremicroservice.services.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encheres")
@CrossOrigin("*")
public class EnchereController {

    @Autowired
    private EnchereService enchereService;

    // GET All
    @GetMapping
    public List<Enchere> getAllEncheres() {
        return enchereService.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enchere> getEnchereById(@PathVariable Long id) {
        Enchere enchere = enchereService.findById(id);
        return enchere != null ? ResponseEntity.ok(enchere) : ResponseEntity.notFound().build();
    }

    // POST (Create)
    @PostMapping
    public ResponseEntity<Enchere> createEnchere(@RequestBody Enchere enchere) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enchereService.save(enchere));
    }

    // PUT (Update)
    @PutMapping("/{id}")
    public ResponseEntity<Enchere> updateEnchere(@PathVariable Long id, @RequestBody Enchere enchere) {
        Enchere existingEnchere = enchereService.findById(id);
        if (existingEnchere == null) return ResponseEntity.notFound().build();

        // Update fields
        existingEnchere.setTitre(enchere.getTitre());
        existingEnchere.setDescription(enchere.getDescription());
        existingEnchere.setPrixInitial(enchere.getPrixInitial());
        existingEnchere.setPrixActuel(enchere.getPrixActuel());
        existingEnchere.setDateDebut(enchere.getDateDebut());
        existingEnchere.setDateFin(enchere.getDateFin());

        return ResponseEntity.ok(enchereService.save(existingEnchere));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnchere(@PathVariable Long id) {
        enchereService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

