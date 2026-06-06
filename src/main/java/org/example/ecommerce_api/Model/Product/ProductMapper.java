package org.example.ecommerce_api.Model.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.name", target = "categoryName")
    ProductResponseDTO toProductResponseDTO(Product product);
    Product toEntity(ProductRequestDTO productRequestDTO);
}

