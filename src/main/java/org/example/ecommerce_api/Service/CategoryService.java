package org.example.ecommerce_api.Service;

import org.example.ecommerce_api.Exception.CategoryNotFoundException;
import org.example.ecommerce_api.Model.Category.Category;
import org.example.ecommerce_api.Model.Category.CategoryMapper;
import org.example.ecommerce_api.Model.Category.CategoryRequestDTO;
import org.example.ecommerce_api.Model.Category.CategoryResponseDTO;
import org.example.ecommerce_api.Model.Product.ProductResponseDTO;
import org.example.ecommerce_api.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,  CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toEntity(categoryRequestDTO);

        Category saved = categoryRepository.save(category);

        return categoryMapper.toCategoryResponseDTO(saved);
    }

    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryResponseDTO)
                .toList();
    }

    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
        return categoryMapper.toCategoryResponseDTO(category);
    }

    public Category findEntityById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
    }

    public CategoryResponseDTO update(CategoryRequestDTO categoryRequestDTO, Long id) {
        Category oldCategory = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));

        oldCategory.setName(categoryRequestDTO.getName());
        oldCategory.setDescription(categoryRequestDTO.getDescription());

        Category saved = categoryRepository.save(oldCategory);

        return categoryMapper.toCategoryResponseDTO(saved);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
