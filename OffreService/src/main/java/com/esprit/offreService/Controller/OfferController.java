package com.esprit.offreService.Controller;

import com.esprit.offreService.Producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.offreService.Entities.Offer;
import com.esprit.offreService.Service.OfferService;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {
    private RabbitMQProducer rabbitMQProducer;

    @Autowired
    public OfferController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getAllOffers() {
        rabbitMQProducer.sendMessage("All offers fetched");
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
        Offer offer = offerService.getOfferById(id);
        rabbitMQProducer.sendMessage("Offre fetched by id: " + id);
        return offer != null ? ResponseEntity.ok(offer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        rabbitMQProducer.sendMessage("Offre Created");
        return offerService.saveOffer(offer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long id, @RequestBody Offer updatedOffer) {
        Offer existingOffer = offerService.getOfferById(id);
        rabbitMQProducer.sendMessage("Offre updated with id: " + id);
        if (existingOffer != null) {
            updatedOffer.setId(id); // Assurez-vous de conserver l'ID
            return ResponseEntity.ok(offerService.saveOffer(updatedOffer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        rabbitMQProducer.sendMessage("Offre deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
