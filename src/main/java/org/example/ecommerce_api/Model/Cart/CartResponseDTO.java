package org.example.ecommerce_api.Model.Cart;

import lombok.Data;
import org.example.ecommerce_api.Model.CartItem.CartItemResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CartResponseDTO {
    private Long id;
    private Long userId;
    private List<CartItemResponseDTO> items;
    private LocalDateTime updatedAt;
}
