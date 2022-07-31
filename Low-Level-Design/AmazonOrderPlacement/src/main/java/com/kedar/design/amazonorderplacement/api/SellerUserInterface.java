package com.kedar.design.amazonorderplacement.api;

public interface SellerUserInterface extends  RegisteredUserInterface {

    void addProductsForSell();

    void fetchSellerGstInvoice();
}
