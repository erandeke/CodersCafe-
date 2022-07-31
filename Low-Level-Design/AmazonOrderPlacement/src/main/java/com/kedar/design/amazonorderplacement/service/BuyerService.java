package com.kedar.design.amazonorderplacement.service;

import com.kedar.design.amazonorderplacement.api.BuyerUserInterface;
import com.kedar.design.amazonorderplacement.constants.ProductCategory;
import com.kedar.design.amazonorderplacement.models.Account;
import com.kedar.design.amazonorderplacement.models.Buyer;
import com.kedar.design.amazonorderplacement.models.Items;
import com.kedar.design.amazonorderplacement.models.Product;

import java.util.List;

public class BuyerService implements BuyerUserInterface {

    private Buyer buyer;
    private LoginService loginService;
    private ProductService productService;

    private ShoppingCartService shoppingCartService;


    public BuyerService(Buyer buyer, LoginService loginService, ProductService productService, ShoppingCartService shoppingCartService) {
        this.buyer = buyer;
        this.loginService = loginService;
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void loginToAccount() {
        Account accountDetails = buyer.getAccount();
        loginService.loginToAccount(accountDetails);
    }

    @Override
    public List<Product> searchForProducts(ProductCategory productCategory) {
        return productService.fetchProducts(productCategory);
    }

    @Override
    public void viewProducts(Items item) {
        //then add to shopping Cart
        this.addProductsToShoppingCart(item);

    }

    @Override
    public void addProductsToShoppingCart(Items items) {
        shoppingCartService.addItemsToShoppingCart(items);
    }

    @Override
    public void checkoutForPlacingTheOrder() {

    }

    @Override
    public void placeOrder() {

    }
}
