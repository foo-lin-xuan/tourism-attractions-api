package sg.edu.ntu.singastays.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.services.AttractionService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    private AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    // @GetMapping("/search")
    // public ResponseEntity<ArrayList<Attraction>> searchAttractions(@RequestParam
    // String attractionName) {
    // ArrayList<Attraction> foundAttractions =
    // attractionService.searchAttractions(attractionName);
    // return new ResponseEntity<>(foundAttractions, HttpStatus.OK);
    // }

    // CREATE
    @PostMapping("")
    public ResponseEntity<?> createAttraction(@Valid @RequestBody Attraction attraction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return a bad request response with the error
            // details
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Attraction newAttraction = attractionService.createAttraction(attraction);
        if (newAttraction == null) {
            // If the creation process failed for some reason, return an internal server
            // error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create attraction");
        }

        // If the creation was successful, return a response with the created attraction
        // and a status of CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(newAttraction);
    }

    // READ (GET ALL)
    @GetMapping("")
    public ResponseEntity<ArrayList<Attraction>> getAllAttractions() {
        ArrayList<Attraction> allAttractions = attractionService.getAllAttractions();
        return new ResponseEntity<>(allAttractions, HttpStatus.OK);
    }

    // READ (GET ONE)
    @GetMapping("/{id}")
    public ResponseEntity<Attraction> getAttraction(@PathVariable Long id) {
        Attraction foundAttraction = attractionService.getAttraction(id);
        return new ResponseEntity<>(foundAttraction, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Attraction> updateAttraction(@PathVariable Long id, @RequestBody Attraction attraction) {
        Attraction updatedAttraction = attractionService.updateAttraction(id, attraction);
        return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Attraction> deleteAttraction(@PathVariable Long id) {
        attractionService.deleteAttraction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
