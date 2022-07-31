package com.kedar.design.amazonorderplacement.service;

import com.kedar.design.amazonorderplacement.constants.ProductCategory;
import com.kedar.design.amazonorderplacement.models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductService {

    protected List<Product> fetchProducts(ProductCategory productCategory)
    {
        /*
        For database implementation:

        this will be implemented like - take the product category
        table PRODUCT : prod_name , prod_id , prod_desc , prod_category
        product_category : ELECTRONICS  category_id  12345_ELCES
        product_category : KITCHEN category_id : 123_KITCHEN
        Select Product.NAME , PRODUCT.DESC , PRODUCT.PRICE from PRODUCT
        where product_category = /%id%

         This will list all the product with details for that particular category

         */
        /*
         For cache implementation : Either use elastic search ->

         For inmemory implementation: Use Trie -> that will take the product name lets say apple
         then from
         */

        return new ArrayList<>();
    }
}
