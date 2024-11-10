package com.esprit.commentaireService.controller;

import com.esprit.commentaireService.Producer.RabbitMQProducer;
import com.esprit.commentaireService.model.Commentaire;
import com.esprit.commentaireService.service.IcommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
@RequiredArgsConstructor
public class CommentaireController {

    private final IcommentaireService commentaireService;
@Autowired
    public CommentaireController(IcommentaireService commentaireService, RabbitMQProducer rabbitMQProducer) {
        this.commentaireService = commentaireService;
        this.rabbitMQProducer = rabbitMQProducer;
    }

    private RabbitMQProducer rabbitMQProducer;

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        rabbitMQProducer.sendMessage("All Commentaires fetched");
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) { // Change to Long
        rabbitMQProducer.sendMessage("Commentaire fetched by id: " + id);
        return commentaireService.getCommentaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire) {
        rabbitMQProducer.sendMessage("SENNT TO RABBITMQQQ");
        return commentaireService.createCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) { // Change to Long
        try {
            Commentaire updatedCommentaire = commentaireService.updateCommentaire(id, commentaire);
            rabbitMQProducer.sendMessage("Commentaire updated: " + updatedCommentaire.toString());
            return ResponseEntity.ok(updatedCommentaire);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) { // Change to Long
        commentaireService.deleteCommentaire(id);
        rabbitMQProducer.sendMessage("Commentaire deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
