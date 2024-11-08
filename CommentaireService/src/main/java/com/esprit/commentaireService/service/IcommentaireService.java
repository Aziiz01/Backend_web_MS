package com.esprit.commentaireService.service;

import com.esprit.commentaireService.model.Commentaire;

import java.util.List;
import java.util.Optional;

public interface IcommentaireService {
    List<Commentaire> getAllCommentaires();
    Optional<Commentaire> getCommentaireById(Long id); // Change to Long

    Commentaire createCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Long id, Commentaire commentaire); // Keep Long

    void deleteCommentaire(Long id); // Change to Long
}
