package sg.edu.ntu.singastays.serviceImpls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.exceptions.AttractionNotFoundException;
import sg.edu.ntu.singastays.repositories.AttractionRepository;

@SpringBootTest
public class AttractionServiceImplTest {
    @Mock
    private AttractionRepository attractionRepository;

    @InjectMocks
    private AttractionServiceImpl attractionService;

    @Test
    public void createAttractionTest() {
        Attraction attraction = new Attraction("Escape Theme Park");

        when(attractionRepository.save(attraction)).thenReturn(attraction);

        Attraction savedAttraction = attractionService.createAttraction(attraction);

        assertEquals(attraction, savedAttraction, "The saved attraction should be the same as the new attraction");

        verify(attractionRepository, times(1)).save(attraction);
    }

    @Test
    public void getAttractionTest() {
        Attraction attraction = new Attraction("Escape Theme Park");

        Long attractionId = 1L;

        when(attractionRepository.findById(attractionId)).thenReturn(Optional.of(attraction));

        Attraction retrievedAttraction = attractionService.getAttraction(attractionId);

        assertEquals(attraction, retrievedAttraction);
    }

    @Test
    public void testGetAttractionNotFound() {
        Long attractionId = 1L;
        when(attractionRepository.findById(attractionId)).thenReturn(Optional.empty());

        assertThrows(AttractionNotFoundException.class, () -> attractionService.getAttraction(attractionId));
    }

    @Test
    public void getAllAttractionsTest() {
        Attraction attraction1 = new Attraction("Escape Theme Park");
        Attraction attraction2 = new Attraction("Adventure Cove");
        Attraction attraction3 = new Attraction("Hydro-Dash");
        ArrayList<Attraction> attractions = new ArrayList<>(Arrays.asList(attraction1, attraction2, attraction3));

        when(attractionRepository.findAll()).thenReturn(attractions);

        ArrayList<Attraction> retrievedAttractions = attractionService.getAllAttractions();

        assertEquals(attractions, retrievedAttractions);
    }

}
