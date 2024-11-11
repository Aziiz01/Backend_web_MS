package com.esprit.commentaireService.service;

import com.esprit.commentaireService.model.Commentaire;

import java.util.List;
import java.util.Optional;

public interface IcommentaireService {
    List<Commentaire> getAllCommentaires();
    Optional<Commentaire> getCommentaireById(String id);
    Commentaire createCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(String id, Commentaire commentaire);
    void deleteCommentaire(String id);
}
