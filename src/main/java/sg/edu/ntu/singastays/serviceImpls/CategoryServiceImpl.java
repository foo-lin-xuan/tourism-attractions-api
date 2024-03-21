package sg.edu.ntu.singastays.serviceImpls;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.entities.Category;
import sg.edu.ntu.singastays.exceptions.AttractionNotFoundException;
import sg.edu.ntu.singastays.exceptions.CategoryAlreadyExistsException;
import sg.edu.ntu.singastays.exceptions.CategoryNotFoundException;
import sg.edu.ntu.singastays.exceptions.DeleteNonEmptyCategoryException;
import sg.edu.ntu.singastays.repositories.AttractionRepository;
import sg.edu.ntu.singastays.repositories.CategoryRepository;
import sg.edu.ntu.singastays.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private AttractionRepository attractionRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, AttractionRepository attractionRepository) {
        this.categoryRepository = categoryRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Attraction addAttractionToCategory(Long id, Long attractionId) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        Attraction attraction = attractionRepository.findById(attractionId)
                .orElseThrow(() -> new AttractionNotFoundException(attractionId));

        attraction.setCategory(category);

        return attractionRepository.save(attraction);
    }

    @Override
    public Category createCategory(Category category) {
        if (categoryRepository.findByName(category.getName()) != null) {
            throw new CategoryAlreadyExistsException(category.getName());
        }
        Category createdCategory = categoryRepository.save(category);
        return createdCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));

        if (!category.getAttractions().isEmpty()) {
            throw new DeleteNonEmptyCategoryException(id);
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        return category;
    }

    @Override
    public Category removeAttractionsFromCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        List<Attraction> attractionsInCategory = category.getAttractions();

        for (Attraction attraction : attractionsInCategory) {
            attraction.setCategory(null);
            attractionRepository.save(attraction);
        }

        return category;
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        categoryToUpdate.setName(category.getName());
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public Category searchCategoriesByName(String name) {
        Category results = categoryRepository.findByName(name);
        return results;
    }

}
