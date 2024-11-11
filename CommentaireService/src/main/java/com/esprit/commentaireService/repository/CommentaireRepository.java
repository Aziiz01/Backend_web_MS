package com.esprit.commentaireService.repository;

import com.esprit.commentaireService.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, String> {
    // Additional query methods if needed
}
