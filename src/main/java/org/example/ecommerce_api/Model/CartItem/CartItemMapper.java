package org.example.ecommerce_api.Model.CartItem;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.price", target = "productPrice")
    CartItemResponseDTO toCartItemResponseDTO(CartItem cartItem);
}
