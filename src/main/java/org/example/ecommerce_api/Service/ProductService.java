package org.example.ecommerce_api.Service;

import org.example.ecommerce_api.Exception.ProductNotFoundException;
import org.example.ecommerce_api.Model.Category.Category;
import org.example.ecommerce_api.Model.Product.Product;
import org.example.ecommerce_api.Model.Product.ProductMapper;
import org.example.ecommerce_api.Model.Product.ProductRequestDTO;
import org.example.ecommerce_api.Model.Product.ProductResponseDTO;
import org.example.ecommerce_api.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryService categoryService,  ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productMapper = productMapper;
    }

    public List<ProductResponseDTO> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return productMapper.toProductResponseDTO(product);
    }

    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Category category =  categoryService.findEntityById(productRequestDTO.getCategoryId());

        Product product = productMapper.toEntity(productRequestDTO);
        product.setCategory(category);
        Product saved = productRepository.save(product);
        return productMapper.toProductResponseDTO(saved);
    }


    public ProductResponseDTO update(ProductRequestDTO productRequestDTO, Long id) {
        Category category = categoryService.findEntityById(productRequestDTO.getCategoryId());

        Product oldProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        oldProduct.setName(productRequestDTO.getName());
        oldProduct.setPrice(productRequestDTO.getPrice());
        oldProduct.setStock(productRequestDTO.getStock());
        oldProduct.setCategory(category);

        Product saved = productRepository.save(oldProduct);


        return productMapper.toProductResponseDTO(saved);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
