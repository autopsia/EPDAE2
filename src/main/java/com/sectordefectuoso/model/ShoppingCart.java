package com.sectordefectuoso.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class ShoppingCart {
    private String cardId;
    private String productId;
    private int quantity;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date registerDate = new Date();

    public ShoppingCart() {
    }

    public ShoppingCart(String cardId, String productId, int quantity) {
        this.cardId = cardId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
