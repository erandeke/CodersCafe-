package com.kedar.design.amazonorderplacement.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Items {
    private Long itemId;
    private List<Product> products;
    private int quantity;
}
