package com.locationvoiture.location.controller;

import com.locationvoiture.location.model.Voiture;
import com.locationvoiture.location.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.locationvoiture.location.service.DatabaseCheckService;


@RestController
@CrossOrigin(origins = "http;//localehost:5173")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;
    @Autowired
    private DatabaseCheckService databaseCheckService;

    @GetMapping("/voiture")
    public List<Voiture> getAllVoitures() {
        return voitureService.getAllVoitures();
    }

    @PostMapping("/voiture/create")
    public Voiture createVoiture(@RequestBody Voiture voiture) {
        return voitureService.createVoiture(voiture);
    }

    @PutMapping("/voiture/{id}") 
public Voiture updateVoiture(@PathVariable long id, @RequestBody Voiture voitureDetails) {
    return voitureService.updateVoiture(id, voitureDetails);
}

    @DeleteMapping("/voiture/delete/{id}")
    public ResponseEntity<String> deleteVoiture(@PathVariable long id) {
    try {
        voitureService.deleteVoiture(id);
        return new ResponseEntity<>("Voiture deleted successfully", HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>("Voiture not found", HttpStatus.NOT_FOUND);
    }
}
   @GetMapping("/voiture/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable long id) {
        Optional<Voiture> voitureOptional = voitureService.getVoitureById(id);
        
        if (voitureOptional.isPresent()) {
            return new ResponseEntity<>(voitureOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    

    @GetMapping("/check-database")
    public String checkDatabaseConnection() {
        if (databaseCheckService.isDatabaseConnected()) {
            return "Connected to the MySQL database!";
        } else {
            return "Failed to connect to the MySQL database.";
        }
    }

}
