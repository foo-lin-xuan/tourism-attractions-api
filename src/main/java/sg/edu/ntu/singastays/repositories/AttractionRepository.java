package sg.edu.ntu.singastays.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.singastays.entities.Attraction;

import java.util.List;


public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    // Custom query to find all attractions with a certain first name
    List<Attraction> findByAttractionCategoryName(String attractionCategoryName);
}