package com.kedar.design.amazonorderplacement.models;

import lombok.Data;
import java.util.List;

@Data
public class ShoppingCart {
    private Long shoppingCartId;
    private Buyer buyer;
    private List<Items> items;
    final double cost;
}
/*

cardinality between shopping cart and items wil be
1 -> shopping cart will have multiple items
multiple shopping carts such can have 1 such item

so m : m
hence mapping table for shopping_cart_items_mapping
_id  shopping_cart_id  item_id

 */