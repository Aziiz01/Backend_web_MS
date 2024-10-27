package com.esprit.offreService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.offreService.Entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}

