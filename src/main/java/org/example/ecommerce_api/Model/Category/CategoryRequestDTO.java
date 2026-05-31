package org.example.ecommerce_api.Model.Category;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CategoryRequestDTO {
    private String name;
    private String description;
}
