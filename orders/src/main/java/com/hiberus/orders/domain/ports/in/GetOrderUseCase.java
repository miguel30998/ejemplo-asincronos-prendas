package com.hiberus.orders.domain.ports.in;

import com.hiberus.orders.infrastructure.DTO.OrderDTO;

import java.util.List;

public interface GetOrderUseCase {


    List<OrderDTO> getOrders();
}
