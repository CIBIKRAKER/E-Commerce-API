package org.example.ecommerce_api.Model.Category;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO toCategoryResponseDTO(Category category);
    Category toEntity(CategoryRequestDTO categoryRequestDTO);
}
