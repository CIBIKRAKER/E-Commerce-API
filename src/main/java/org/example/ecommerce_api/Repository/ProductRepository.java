package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
