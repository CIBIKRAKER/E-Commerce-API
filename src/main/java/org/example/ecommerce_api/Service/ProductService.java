package org.example.ecommerce_api.Service;

import org.example.ecommerce_api.Exception.ProductNotFoundException;
import org.example.ecommerce_api.Model.Category.Category;
import org.example.ecommerce_api.Model.Product.Product;
import org.example.ecommerce_api.Model.Product.ProductRequestDTO;
import org.example.ecommerce_api.Model.Product.ProductResponseDTO;
import org.example.ecommerce_api.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Category category =  categoryService.findById(productRequestDTO.getCategoryId());

        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(savedProduct.getId());
        productResponseDTO.setName(savedProduct.getName());
        productResponseDTO.setDescription(savedProduct.getDescription());
        productResponseDTO.setPrice(savedProduct.getPrice());
        productResponseDTO.setStock(savedProduct.getStock());
        productResponseDTO.setCategoryName(savedProduct.getCategory().getName());

        return productResponseDTO;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    public ProductResponseDTO update(ProductRequestDTO productRequestDTO, Long id) {
        Category category = categoryService.findById(productRequestDTO.getCategoryId());

        Product oldProduct = findById(id);
        oldProduct.setName(productRequestDTO.getName());
        oldProduct.setPrice(productRequestDTO.getPrice());
        oldProduct.setStock(productRequestDTO.getStock());
        oldProduct.setCategory(category);

        Product saved = productRepository.save(oldProduct);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(saved.getId());
        productResponseDTO.setName(saved.getName());
        productResponseDTO.setDescription(saved.getDescription());
        productResponseDTO.setPrice(saved.getPrice());
        productResponseDTO.setStock(saved.getStock());
        productResponseDTO.setCategoryName(saved.getCategory().getName());
        productResponseDTO.setCreatedAt(saved.getCreatedAt());
        return productResponseDTO;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
