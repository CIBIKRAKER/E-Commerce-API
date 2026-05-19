package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
