// AttractionServiceImpl.java

package sg.edu.ntu.singastays.serviceImpls;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.entities.Interaction;
import sg.edu.ntu.singastays.exceptions.AttractionNotFoundException;
import sg.edu.ntu.singastays.repositories.AttractionRepository;
import sg.edu.ntu.singastays.repositories.InteractionRepository;
import sg.edu.ntu.singastays.services.AttractionService;

@Service
public class AttractionServiceImpl implements AttractionService {
    
    private final AttractionRepository attractionRepository;
    private final InteractionRepository interactionRepository;

    public AttractionServiceImpl(AttractionRepository attractionRepository, InteractionRepository interactionRepository) {
        this.attractionRepository = attractionRepository;
        this.interactionRepository = interactionRepository;
    }

    @Override
    public Attraction createAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    @Override
    public Attraction getAttraction(Long id) {
        return attractionRepository.findById(id).orElseThrow(() -> new AttractionNotFoundException(id));
    }

    @Override
    public ArrayList<Attraction> getAllAttractions() {
        return new ArrayList<>(attractionRepository.findAll());
    }

    @Override
    public Attraction updateAttraction(Long id, Attraction attraction) {
        Attraction existingAttraction = getAttraction(id);
        existingAttraction.setAttractionName(attraction.getAttractionName());
        existingAttraction.setAttractionCategoryName(attraction.getAttractionCategoryName());
        existingAttraction.setAttractionCreatedDate(attraction.getAttractionCreatedDate());
        existingAttraction.setAttractionUpdatedDate(attraction.getAttractionUpdatedDate());
        return attractionRepository.save(existingAttraction);
    }

    @Override
    public void deleteAttraction(Long id) {
        attractionRepository.deleteById(id);
    }

    @Override
    public Interaction addInteractionToAttraction(Long id, Interaction interaction) {
        Attraction attraction = getAttraction(id);
        interaction.setAttraction(attraction);
        return interactionRepository.save(interaction);
    }

    @Override
    public ArrayList<Attraction> searchAttractions(String attractionCategoryName) {
        List<Attraction> foundAttractions = attractionRepository.findByAttractionCategoryName(attractionCategoryName);
        return new ArrayList<>(foundAttractions);
    }
}
