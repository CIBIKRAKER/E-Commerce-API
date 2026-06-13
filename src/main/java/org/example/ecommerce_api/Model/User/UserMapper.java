package org.example.ecommerce_api.Model.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toUserResponseDTO(User user);
    User toEntity(UserRequestDTO userRequestDTO);
}
