package org.example.ecommerce_api.Repository;

import org.example.ecommerce_api.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
