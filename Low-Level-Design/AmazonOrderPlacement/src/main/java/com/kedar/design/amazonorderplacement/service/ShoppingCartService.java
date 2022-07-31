package com.kedar.design.amazonorderplacement.service;

import com.kedar.design.amazonorderplacement.models.Items;
import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartService {


    protected void addItemsToShoppingCart(Items item)
    {
        /*
         For  database implementation :

         Let your shopping cart entity be user id and item id stored as composite key

          SC:

          id  user_id_product_id product_id user_id

          So while fetching the cart details I can simply query userid and it will internal query product
          table to get the details of that product




         */

    }


}
