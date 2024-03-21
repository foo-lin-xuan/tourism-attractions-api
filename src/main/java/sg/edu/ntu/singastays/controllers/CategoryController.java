package sg.edu.ntu.singastays.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.entities.Category;
import sg.edu.ntu.singastays.services.CategoryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Category foundCategory = categoryService.getCategory(id);
        return new ResponseEntity<Category>(foundCategory, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) throws Exception {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/attractions")
    public ResponseEntity<Attraction> addAttractionToCategory(@PathVariable Long id, @RequestParam Long attractionId) {
        Attraction addedAttraction = categoryService.addAttractionToCategory(id, attractionId);
        return new ResponseEntity<>(addedAttraction, HttpStatus.OK);
    }

    @PutMapping("/{id}/attractions")
    public ResponseEntity<Category> removeAttractionsFromCategory(@PathVariable Long id) {
        Category category = categoryService.removeAttractionsFromCategory(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Category> searchCategoryByName(@RequestParam String name) {
        Category results = categoryService.searchCategoriesByName(name);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
