package sg.edu.ntu.singastays.services;

import java.util.List;

import sg.edu.ntu.singastays.entities.UserFavourite;

public interface UserFavouriteService {
    List<UserFavourite> getAllUserFavourites();
    UserFavourite getUserFavouriteById(Long id);
    UserFavourite createUserFavourite(UserFavourite userFavourite);
    UserFavourite updateUserFavourite(Long id, UserFavourite userFavourite);
    void deleteUserFavourite(Long id);
}
