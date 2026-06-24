package org.example.ecommerce_api.Model.Cart;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(source = "user.id", target = "userId")
    CartResponseDTO toCartResponseDTO(Cart cart);
}
