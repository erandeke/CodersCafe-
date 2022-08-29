package com.kedar.java8.code.streams.conversion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 */
class Product {
    int productId;
    String productName;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class ConvertIntoDifferentDataStructures {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Set<Integer> res = list.stream().collect(Collectors.toSet());
        System.out.println(res);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        List<Integer> ans = set.stream().toList();
        System.out.println(ans);

        //Convert List of Products into Map

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product(1, "Asset"));
        listOfProducts.add(new Product(2, "Mobile"));

        Map<Integer, String> map = listOfProducts.stream()
                .collect(Collectors.toMap(p -> p.productId, p -> p.productName));
        System.out.println(map);


    }
}
