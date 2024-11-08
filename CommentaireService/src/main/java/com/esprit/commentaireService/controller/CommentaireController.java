package com.esprit.commentaireService.controller;

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
    public CommentaireController(IcommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) { // Change to Long
        return commentaireService.getCommentaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireService.createCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) { // Change to Long
        try {
            Commentaire updatedCommentaire = commentaireService.updateCommentaire(id, commentaire);
            return ResponseEntity.ok(updatedCommentaire);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) { // Change to Long
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.noContent().build();
    }
}
