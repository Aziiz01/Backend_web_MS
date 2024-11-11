package com.esprit.commentaireService.service;

import com.esprit.commentaireService.model.Commentaire;
import com.esprit.commentaireService.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireImp implements IcommentaireService {

    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireImp(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public Optional<Commentaire> getCommentaireById(String id) {
        return commentaireRepository.findById(id);
    }

    @Override
    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(String id, Commentaire commentaire) {
        if (commentaireRepository.existsById(id)) {
            commentaire.setId(id); // Make sure the ID is set for updating
            return commentaireRepository.save(commentaire);
        } else {
            throw new RuntimeException("Commentaire not found with id " + id);
        }
    }

    @Override
    public void deleteCommentaire(String id) {
        commentaireRepository.deleteById(id);
    }
}
