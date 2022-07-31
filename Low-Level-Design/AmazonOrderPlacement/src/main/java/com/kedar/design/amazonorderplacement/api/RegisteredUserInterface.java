package com.kedar.design.amazonorderplacement.api;

import com.kedar.design.amazonorderplacement.constants.ProductCategory;
import com.kedar.design.amazonorderplacement.models.Items;
import com.kedar.design.amazonorderplacement.models.Product;

import java.util.List;

public interface RegisteredUserInterface {

    void loginToAccount();

    List<Product> searchForProducts(ProductCategory productCategory);

    void viewProducts(Items item);

}
