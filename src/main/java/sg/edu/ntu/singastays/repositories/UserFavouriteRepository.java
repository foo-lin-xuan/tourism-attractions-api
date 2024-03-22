package sg.edu.ntu.singastays.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.singastays.entities.UserFavourite;
import sg.edu.ntu.singastays.services.UserFavouriteService;

@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavourite, Long> {

    
}
