package com.esprit.encheremicroservice.repositories;

import com.esprit.encheremicroservice.entities.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnchereRepository extends JpaRepository<Enchere, Long> {
}

