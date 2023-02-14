package com.hiberus.orders.application.service;

import com.hiberus.orders.domain.ports.in.GetOrderUseCase;
import com.hiberus.orders.domain.ports.out.OrdersPort;
import com.hiberus.orders.infrastructure.DTO.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class GetOrderUseCaseImpl implements GetOrderUseCase {

    @Autowired
    private final OrdersPort ordersPort;
    @Override
    public List<OrderDTO> getOrders() {
       return ordersPort.getOrders();
    }
}
