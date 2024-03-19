package sg.edu.ntu.singastays.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.singastays.entities.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    
}
