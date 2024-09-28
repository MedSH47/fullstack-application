package com.locationvoiture.location.controller;

import com.locationvoiture.location.model.Voiture;
import com.locationvoiture.location.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @GetMapping("")
    public List<Voiture> getAllVoitures() {
        return voitureService.getAllVoitures();
    }

    @PostMapping
    public Voiture createVoiture(@RequestBody Voiture voiture) {
        return voitureService.createVoiture(voiture);
    }

    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable long id, @RequestBody Voiture voitureDetails) {
        return voitureService.updateVoiture(id, voitureDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable long id) {
        voitureService.deleteVoiture(id);
    }

    @GetMapping("/getHello")
    public String getHello(){
        return voitureService.getHello();
    }
}
