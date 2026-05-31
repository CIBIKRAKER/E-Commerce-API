package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
