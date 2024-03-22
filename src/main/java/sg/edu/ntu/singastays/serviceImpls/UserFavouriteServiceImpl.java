package sg.edu.ntu.singastays.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import sg.edu.ntu.singastays.entities.UserFavourite;
import sg.edu.ntu.singastays.repositories.UserFavouriteRepository;
import sg.edu.ntu.singastays.services.UserFavouriteService;

@Service
public class UserFavouriteServiceImpl implements UserFavouriteService {
    
    @Autowired
    private UserFavouriteRepository userFavouriteRepository;

    @Override
    public ArrayList<UserFavourite> getAllUserFavourites() {
        return (ArrayList<UserFavourite>) userFavouriteRepository.findAll();
    }

    @Override
    public UserFavourite getUserFavouriteById(Long id) {
        return userFavouriteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserFavourite with id " + id + " not found"));
    }

    @Override
    public UserFavourite createUserFavourite(UserFavourite userFavourite) {
        return userFavouriteRepository.save(userFavourite);
    }

    @Override
    public UserFavourite updateUserFavourite(Long id, UserFavourite userFavourite) {
        UserFavourite existingUserFavourite = userFavouriteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserFavourite with id " + id + " not found"));
        existingUserFavourite.setUser(userFavourite.getUser());
        existingUserFavourite.setAttraction(userFavourite.getAttraction());
        // Set other fields as needed
        return userFavouriteRepository.save(existingUserFavourite);
    }

    @Override
    public void deleteUserFavourite(Long id) {
        if (!userFavouriteRepository.existsById(id)) {
            throw new EntityNotFoundException("UserFavourite with id " + id + " not found");
        }
        userFavouriteRepository.deleteById(id);
    }

}
