package org.example.ecommerce_api.Service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductService productService;

    public ProductService(ProductService productService) {
        this.productService = productService;
    }


}
