package org.example.ecommerce_api.Controller;

import org.example.ecommerce_api.Model.Product.Product;
import org.example.ecommerce_api.Model.Product.ProductRequestDTO;
import org.example.ecommerce_api.Model.Product.ProductResponseDTO;
import org.example.ecommerce_api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll()
    {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO)
    {
        return ResponseEntity.ok(productService.save(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update (@RequestBody ProductRequestDTO product, @PathVariable Long id)
    {
        return ResponseEntity.ok(productService.update(product, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
