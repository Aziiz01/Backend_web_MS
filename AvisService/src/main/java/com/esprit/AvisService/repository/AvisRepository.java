package com.esprit.AvisService.repository;

import com.esprit.AvisService.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends JpaRepository<Avis, String> {
    List<Avis> findByBidId(String bidId);
    List<Avis> findByUserId(String userId);
}