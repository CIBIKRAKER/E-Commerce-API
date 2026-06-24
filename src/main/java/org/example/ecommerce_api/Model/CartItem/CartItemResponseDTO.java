package org.example.ecommerce_api.Model.CartItem;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemResponseDTO {
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
}
