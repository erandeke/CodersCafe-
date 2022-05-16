package com.kedar.design.amazonorderplacement.models;

import com.kedar.design.amazonorderplacement.constants.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {
    private Long product_id;
    private String product_Name;
    private String product_description;
    private List<ProductReview> productReviewList;
    private ProductCategory productCategory;
}
