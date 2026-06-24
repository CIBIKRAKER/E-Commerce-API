package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUserId(Long id);
}
