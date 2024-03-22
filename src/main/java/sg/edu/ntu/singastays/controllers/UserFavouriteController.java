package sg.edu.ntu.singastays.controllers;

import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.singastays.entities.UserFavourite;
import sg.edu.ntu.singastays.services.UserFavouriteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user-favourites")

public class UserFavouriteController {
    
    @Autowired
    private UserFavouriteService userFavouriteService;

    // Create a new UserFavourite
    @PostMapping
    public ResponseEntity<UserFavourite> createUserFavourite(@RequestBody UserFavourite userFavourite) {
        UserFavourite newUserFavourite = userFavouriteService.createUserFavourite(userFavourite);
        return new ResponseEntity<>(newUserFavourite, HttpStatus.CREATED);
    }

    // Get all UserFavourites
    @GetMapping
    public ResponseEntity<List<UserFavourite>> getAllUserFavourites() {
        List<UserFavourite> userFavourites = userFavouriteService.getAllUserFavourites();
        return new ResponseEntity<>(userFavourites, HttpStatus.OK);
    }

    // Get UserFavourite by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserFavourite> getUserFavouriteById(@PathVariable Long id) {
        UserFavourite userFavourite = userFavouriteService.getUserFavouriteById(id);
        return new ResponseEntity<>(userFavourite, HttpStatus.OK);
    }

    // Update UserFavourite by ID
    @PutMapping("/{id}")
    public ResponseEntity<UserFavourite> updateUserFavourite(@PathVariable Long id, @RequestBody UserFavourite userFavourite) {
        UserFavourite updatedUserFavourite = userFavouriteService.updateUserFavourite(id, userFavourite);
        return new ResponseEntity<>(updatedUserFavourite, HttpStatus.OK);
    }

    // Delete UserFavourite by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFavourite(@PathVariable Long id) {
        userFavouriteService.deleteUserFavourite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
