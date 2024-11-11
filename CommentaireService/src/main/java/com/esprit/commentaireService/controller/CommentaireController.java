package com.esprit.commentaireService.controller;

import com.esprit.commentaireService.Producer.RabbitMQProducer;
import com.esprit.commentaireService.model.Commentaire;
import com.esprit.commentaireService.service.IcommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    private final IcommentaireService commentaireService;

    @Autowired
    public CommentaireController(RabbitMQProducer rabbitMQProducer, IcommentaireService commentaireService) {
        this.commentaireService = commentaireService;
        this.rabbitMQProducer = rabbitMQProducer;

    }
    private RabbitMQProducer rabbitMQProducer;

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        rabbitMQProducer.sendMessage("All comments fetched ");
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable String id) {
        rabbitMQProducer.sendMessage("Commentaire fetched by id: " + id);
        return commentaireService.getCommentaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire) {
        rabbitMQProducer.sendMessage("COMMENT CREATED");
        return commentaireService.createCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable String id, @RequestBody Commentaire commentaire) {
        try {
            Commentaire updatedCommentaire = commentaireService.updateCommentaire(id, commentaire);
            rabbitMQProducer.sendMessage("commentaire updated: " + updatedCommentaire.toString());
            return ResponseEntity.ok(updatedCommentaire);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable String id) {
        commentaireService.deleteCommentaire(id);
        rabbitMQProducer.sendMessage("commentaire deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
