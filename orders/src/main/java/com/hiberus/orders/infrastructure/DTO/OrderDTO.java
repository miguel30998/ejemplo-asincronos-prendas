package com.hiberus.orders.infrastructure.DTO;


import lombok.Builder;

@Builder
public class OrderDTO {

    String orderId;

    String garmentId;

    String userId;

}
