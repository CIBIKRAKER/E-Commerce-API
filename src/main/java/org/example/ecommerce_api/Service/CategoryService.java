package org.example.ecommerce_api.Service;

import org.example.ecommerce_api.Exception.CategoryNotFoundException;
import org.example.ecommerce_api.Model.Category.Category;
import org.example.ecommerce_api.Model.Category.CategoryRequestDTO;
import org.example.ecommerce_api.Model.Category.CategoryResponseDTO;
import org.example.ecommerce_api.Model.Product.ProductResponseDTO;
import org.example.ecommerce_api.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setName(categoryRequestDTO.getName());
        category.setDescription(categoryRequestDTO.getDescription());
        Category saved = categoryRepository.save(category);

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setId(saved.getId());
        categoryResponseDTO.setCategoryName(saved.getName());
        categoryResponseDTO.setCategoryDescription(saved.getDescription());
        categoryResponseDTO.setCreatedDate(saved.getCreatedAt());
        return categoryResponseDTO;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
    }

    public CategoryResponseDTO update(CategoryRequestDTO categoryRequestDTO, Long id) {
        Category oldCategory = findById(id);

        oldCategory.setName(categoryRequestDTO.getName());
        oldCategory.setDescription(categoryRequestDTO.getDescription());

        Category saved = categoryRepository.save(oldCategory);

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setId(saved.getId());
        categoryResponseDTO.setCategoryName(saved.getName());
        categoryResponseDTO.setCategoryDescription(saved.getDescription());
        categoryResponseDTO.setCreatedDate(saved.getCreatedAt());
        return categoryResponseDTO;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
