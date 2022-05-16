package com.kedar.design.amazonorderplacement.models;

import com.kedar.design.amazonorderplacement.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private Long orderId;
    private List<Items> itemsList;
    private Buyer buyer;
    private NotificationDomain notificationDomain;
    private OrderStatus orderStatus;



}
