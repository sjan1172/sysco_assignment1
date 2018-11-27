package com.sysco.assignment1.models;

import java.util.List;

public class CartDetails {
    private List<CartItem> cartItems;

    public CartDetails(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
