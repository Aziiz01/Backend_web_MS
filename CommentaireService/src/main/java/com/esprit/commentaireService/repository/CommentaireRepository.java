package com.esprit.commentaireService.repository;

import com.esprit.commentaireService.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> { // Use Long as ID type
    // No need for additional methods; JpaRepository already provides these
}
