package com.kedar.design.amazonorderplacement.models;

import lombok.Data;

import java.util.List;

@Data
public class Buyer extends BaseUser {

    private Account account;
    private List<Order> oder;
    private ShoppingCart shoppingCart;





}
