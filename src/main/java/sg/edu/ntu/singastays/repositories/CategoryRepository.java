package sg.edu.ntu.singastays.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.singastays.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
