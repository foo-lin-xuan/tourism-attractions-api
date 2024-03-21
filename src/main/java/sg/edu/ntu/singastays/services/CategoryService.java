package sg.edu.ntu.singastays.services;

import java.util.List;

import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.entities.Category;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategory(Long id);

    List<Category> getAllCategories();

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    Attraction addAttractionToCategory(Long id, Long attractionId);

    Category removeAttractionsFromCategory(Long id);

    Category searchCategoriesByName(String name);
}
