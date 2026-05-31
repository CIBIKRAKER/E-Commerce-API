package org.example.ecommerce_api.Model.Category;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String categoryName;
    private String categoryDescription;
    private LocalDateTime createdDate;
}
