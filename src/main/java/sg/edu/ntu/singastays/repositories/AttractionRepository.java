package sg.edu.ntu.singastays.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.singastays.entities.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

}
