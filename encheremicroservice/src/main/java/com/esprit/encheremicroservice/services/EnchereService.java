package com.esprit.encheremicroservice.services;


import com.esprit.encheremicroservice.entities.Enchere;
import com.esprit.encheremicroservice.repositories.EnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnchereService {

    @Autowired
    private EnchereRepository enchereRepository;

    public List<Enchere> findAll() {
        return enchereRepository.findAll();
    }

    public Enchere findById(Long id) {
        return enchereRepository.findById(id).orElse(null);
    }

    public Enchere save(Enchere enchere) {
        return enchereRepository.save(enchere);
    }

    public void deleteById(Long id) {
        enchereRepository.deleteById(id);
    }
}

