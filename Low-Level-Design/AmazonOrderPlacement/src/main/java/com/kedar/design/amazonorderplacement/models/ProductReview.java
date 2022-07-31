package com.kedar.design.amazonorderplacement.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReview {

    private Long product_review_id;
    private int rating;
    private String productReviewDesc;
    private Buyer buyer;

}
