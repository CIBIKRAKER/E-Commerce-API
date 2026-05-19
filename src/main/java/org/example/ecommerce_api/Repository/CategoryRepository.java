package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
