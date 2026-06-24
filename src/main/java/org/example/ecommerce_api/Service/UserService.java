package org.example.ecommerce_api.Service;

import org.example.ecommerce_api.Exception.UserNotFoundException;
import org.example.ecommerce_api.Model.Cart.Cart;
import org.example.ecommerce_api.Model.User.User;
import org.example.ecommerce_api.Model.User.UserMapper;
import org.example.ecommerce_api.Model.User.UserRequestDTO;
import org.example.ecommerce_api.Model.User.UserResponseDTO;
import org.example.ecommerce_api.Repository.CartRepository;
import org.example.ecommerce_api.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CartRepository cartRepository;

    public UserService(UserRepository userRepository,  UserMapper userMapper, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.cartRepository = cartRepository;
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        // TODO: hash password with BCrypt when security is added
        user.setHashedPassword(userRequestDTO.getPassword());
        User saved =  userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);

        return userMapper.toUserResponseDTO(saved);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponseDTO)
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO update(UserRequestDTO userRequestDTO, Long id) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));

        oldUser.setEmail(userRequestDTO.getEmail());
        oldUser.setFirstName(userRequestDTO.getFirstName());
        oldUser.setLastName(userRequestDTO.getLastName());
        // TODO: hash password with BCrypt when security is added
        oldUser.setHashedPassword(userRequestDTO.getPassword());
        oldUser.setRole(userRequestDTO.getRole());

        User saved = userRepository.save(oldUser);
        return userMapper.toUserResponseDTO(saved);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
