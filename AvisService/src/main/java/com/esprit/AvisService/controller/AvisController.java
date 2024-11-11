package com.esprit.AvisService.controller;

import com.esprit.AvisService.Producer.RabbitMQProducer;
import com.esprit.AvisService.model.Avis;
import com.esprit.AvisService.service.IAvisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AvisController {

    private final IAvisService avisService;

    @Autowired
    public AvisController(RabbitMQProducer rabbitMQProducer,IAvisService avisService) {
        this.avisService = avisService;
        this.rabbitMQProducer = rabbitMQProducer;

    }

    private RabbitMQProducer rabbitMQProducer;


    @PostMapping
    public ResponseEntity<Avis> createAvis(@RequestBody Avis avis) {
        Avis createdAvis = avisService.createAvis(avis);
        rabbitMQProducer.sendMessage("AVIS CREATED");
        return new ResponseEntity<>(createdAvis, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avis> updateAvis(@PathVariable String id, @RequestBody Avis avis) {
        Avis updatedAvis = avisService.updateAvis(id, avis);
        rabbitMQProducer.sendMessage("Avis updated: " + updatedAvis.toString());
        return ResponseEntity.ok(updatedAvis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvis(@PathVariable String id) {
        avisService.deleteAvis(id);
        rabbitMQProducer.sendMessage("Avis deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable String id) {
        Avis avis = avisService.getAvisById(id);
        rabbitMQProducer.sendMessage("Avis fetched by id: " + id);
        return ResponseEntity.ok(avis);
    }

    @GetMapping
    public ResponseEntity<List<Avis>> getAllAvis() {
        List<Avis> avisList = avisService.getAllAvis();
        rabbitMQProducer.sendMessage("All Avis fetched, count: " + avisList.size());
        return ResponseEntity.ok(avisList);
    }

    @GetMapping("/bid/{bidId}")
    public ResponseEntity<List<Avis>> getAvisByBidId(@PathVariable String bidId) {
        List<Avis> avisList = avisService.getAvisByBidId(bidId);
        rabbitMQProducer.sendMessage("Avis fetched by bidId: " + bidId + ", count: " + avisList.size());
        return ResponseEntity.ok(avisList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Avis>> getAvisByUserId(@PathVariable String userId) {
        List<Avis> avisList = avisService.getAvisByUserId(userId);
        rabbitMQProducer.sendMessage("Avis fetched by userId: " + userId + ", count: " + avisList.size());
        return ResponseEntity.ok(avisList);
    }
}
