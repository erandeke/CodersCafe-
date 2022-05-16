package com.kedar.design.amazonorderplacement.api;

import com.kedar.design.amazonorderplacement.models.Items;

public interface BuyerUserInterface extends RegisteredUserInterface {

    void addProductsToShoppingCart(Items items);

    void checkoutForPlacingTheOrder();

    void placeOrder();

}
