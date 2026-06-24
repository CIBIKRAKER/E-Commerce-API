package org.example.ecommerce_api.Model.Cart;

import lombok.Data;

@Data
public class CartRequestDTO {
    private long userId;
    private long productId;
    private Integer quantity;
}
