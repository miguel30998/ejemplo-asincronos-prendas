package com.hiberus.orders.infrastructure.adapter.out.persistence;

import com.hiberus.orders.infrastructure.DTO.OrderDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DtoToEntityMapper {

    public List<OrderDTO> orderDTOList(List<OrderEntity> orderEntityList) {
        List<OrderDTO> dtoList = new ArrayList<>();
        for (OrderEntity order : orderEntityList) {
            dtoList.add(orderDTO(order));
        }
        return dtoList;
    }

    public OrderDTO orderDTO(OrderEntity order){
     return   OrderDTO.builder()
                .orderId(order.getOrderIdentification())
                .garmentId(order.getGarmentId())
                .userId(order.getUserId())
                .build();
    }
}
