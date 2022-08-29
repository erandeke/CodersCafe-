package com.kedar.java8.code.methodReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class Product {

    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    private static String apply(Product product) {
        return product.productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Asset", 100.2));
        productList.add(new Product(2, "Mobile", 50));
        productList.add(new Product(3, "Machine", 20));
        productList.add(new Product(4, "Laptops", 60));

        productList.stream().filter(s -> s.price > 20)
                .map(Product::apply)
                .forEach(p -> System.out.println(p));


    }
}
