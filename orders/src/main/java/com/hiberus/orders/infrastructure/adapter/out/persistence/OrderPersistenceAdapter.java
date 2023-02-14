package com.hiberus.orders.infrastructure.adapter.out.persistence;

import com.hiberus.orders.domain.ports.out.OrdersPort;
import com.hiberus.orders.infrastructure.DTO.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class OrderPersistenceAdapter implements OrdersPort {


    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final DtoToEntityMapper dtoToEntityMapper;

    @Override
    public List<OrderDTO> getOrders() {
       List<OrderEntity> entityList= orderRepository.findAll();
       return dtoToEntityMapper.orderDTOList(entityList);
    }
}
