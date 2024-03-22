package sg.edu.ntu.singastays.services;

import java.util.ArrayList;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.entities.Interaction;

public interface AttractionService {
    
    Attraction createAttraction(Attraction attraction);

    Attraction getAttraction(Long id);

    ArrayList<Attraction> getAllAttractions();

    Attraction updateAttraction(Long id, Attraction attraction);

    void deleteAttraction(Long id);

    Interaction addInteractionToAttraction(Long id, Interaction interaction);

    ArrayList<Attraction> searchAttractions(String attractionCategoryName);
}
