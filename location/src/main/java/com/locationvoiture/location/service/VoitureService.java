package com.locationvoiture.location.service;

import java.util.List;
import java.util.Optional;

import com.locationvoiture.location.model.Voiture;
import com.locationvoiture.location.repository.VoitureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    public List<Voiture> getAllVoitures(){
        return voitureRepository.findAll();
    }
    public Voiture createVoiture(Voiture voiture){
        return voitureRepository.save(voiture);
    }
    public Voiture updateVoiture(long id,Voiture voitureDetails){
        Voiture voiture = voitureRepository.findById(id).orElseThrow();
        voiture.setMarque(voitureDetails.getMarque());
        voiture.setPrix(voitureDetails.getPrix());
        return voitureRepository.save(voiture);
        
    }
    public void deleteVoiture(long id){
        voitureRepository.deleteById(id);
    }

    public Optional<Voiture> getVoitureById(long id){
        return voitureRepository.findById(id);
    }

}
