package com.hiberus.orders.domain.ports.out;

import com.hiberus.orders.infrastructure.DTO.OrderDTO;

import java.util.List;

public interface OrdersPort {

    List<OrderDTO>getOrders();
}
