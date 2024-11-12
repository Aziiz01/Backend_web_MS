package com.esprit.offreService.Controller;

import com.esprit.offreService.Producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.offreService.Client.CommentaireClient;
import com.esprit.offreService.Entities.Offer;
import com.esprit.offreService.Service.OfferService;
import com.esprit.offreService.dto.CommentaireDTO;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {
    private final RabbitMQProducer rabbitMQProducer;
    private final OfferService offerService;
    private final CommentaireClient commentaireClient;

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
            updatedOffer.setId(id);
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
    @GetMapping("/api/offers/{offerId}/comments")
public ResponseEntity<List<CommentaireDTO>> getCommentairesByOfferId(@PathVariable Long offerId) {
    List<CommentaireDTO> commentaires = commentaireClient.getCommentairesByOfferId(offerId);
    return ResponseEntity.ok(commentaires);
}

}
