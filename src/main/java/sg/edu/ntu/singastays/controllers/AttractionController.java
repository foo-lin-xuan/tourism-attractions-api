package sg.edu.ntu.singastays.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.repositories.AttractionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private AttractionRepository attractionRepository;

    public AttractionController(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Attraction>> getAllAttractions() {
        return new ResponseEntity<>(attractionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attraction> getAttraction(@PathVariable Long id) {
        Optional<Attraction> optionalAttraction = attractionRepository.findById(id);
        if (optionalAttraction.isPresent()) {
            Attraction foundAttraction = optionalAttraction.get();
            return new ResponseEntity<Attraction>(foundAttraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Attraction> createAttraction(@RequestBody Attraction attraction) {
        Attraction createdAttraction = attractionRepository.save(attraction);
        return new ResponseEntity<>(createdAttraction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attraction> updateAttraction(@PathVariable Long id, @RequestBody Attraction attraction) {
        Optional<Attraction> optionalAttraction = attractionRepository.findById(id);
        if (optionalAttraction.isPresent()) {
            Attraction attractionToUpdate = optionalAttraction.get();
            attractionToUpdate.setName(attraction.getName());
            attractionToUpdate.setCategory(attraction.getCategory());
            Attraction updatedAttraction = attractionRepository.save(attractionToUpdate);
            return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Attraction> deleteAttraction(@PathVariable Long id) {
        attractionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchAttraction(@RequestParam String searchTerm) {
        // TODO: process SEARCH method
        return new ResponseEntity<String>("search attraction", HttpStatus.OK);
    }
}
