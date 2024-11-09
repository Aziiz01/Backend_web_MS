package com.esprit.AvisService.service;


import com.esprit.AvisService.model.Avis;

import java.util.List;

public interface IAvisService {
    Avis createAvis(Avis avis);
    Avis updateAvis(String id, Avis avis);
    void deleteAvis(String id);
    Avis getAvisById(String id);
    List<Avis> getAllAvis();
    List<Avis> getAvisByBidId(String bidId);
    List<Avis> getAvisByUserId(String userId);
}