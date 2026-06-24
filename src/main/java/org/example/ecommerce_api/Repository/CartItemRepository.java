package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.CartItem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
