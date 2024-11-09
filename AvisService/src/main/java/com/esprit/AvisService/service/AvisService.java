package com.esprit.AvisService.service;


import com.esprit.AvisService.model.Avis;
import com.esprit.AvisService.repository.AvisRepository;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvisService implements IAvisService {

    private final AvisRepository avisRepository;

    @Override
    public Avis createAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    @Override
    public Avis updateAvis(String id, Avis avisDetails) {
        Avis avis = avisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avis not found with id: " + id));

        avis.setRating(avisDetails.getRating());
        avis.setComment(avisDetails.getComment());
        avis.setUpdatedAt(avisDetails.getUpdatedAt());
        return avisRepository.save(avis);
    }

    @Override
    public void deleteAvis(String id) {
        Avis avis = avisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avis not found with id: " + id));
        avisRepository.delete(avis);
    }

    @Override
    public Avis getAvisById(String id) {
        return avisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avis not found with id: " + id));
    }

    @Override
    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    @Override
    public List<Avis> getAvisByBidId(String bidId) {
        return avisRepository.findByBidId(bidId);
    }

    @Override
    public List<Avis> getAvisByUserId(String userId) {
        return avisRepository.findByUserId(userId);
    }
}

