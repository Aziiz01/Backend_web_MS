package com.esprit.AvisService.controller;



import com.esprit.AvisService.model.Avis;
import com.esprit.AvisService.service.IAvisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
@RequiredArgsConstructor
public class AvisController {

    private final IAvisService avisService;

    @PostMapping
    public ResponseEntity<Avis> createAvis(@RequestBody Avis avis) {
        return new ResponseEntity<>(avisService.createAvis(avis), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avis> updateAvis(@PathVariable String id, @RequestBody Avis avis) {
        return ResponseEntity.ok(avisService.updateAvis(id, avis));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvis(@PathVariable String id) {
        avisService.deleteAvis(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable String id) {
        return ResponseEntity.ok(avisService.getAvisById(id));
    }

    @GetMapping
    public ResponseEntity<List<Avis>> getAllAvis() {
        return ResponseEntity.ok(avisService.getAllAvis());
    }

    @GetMapping("/bid/{bidId}")
    public ResponseEntity<List<Avis>> getAvisByBidId(@PathVariable String bidId) {
        return ResponseEntity.ok(avisService.getAvisByBidId(bidId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Avis>> getAvisByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(avisService.getAvisByUserId(userId));
    }
}