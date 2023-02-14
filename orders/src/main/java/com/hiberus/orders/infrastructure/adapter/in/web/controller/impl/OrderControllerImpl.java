package com.hiberus.orders.infrastructure.adapter.in.web.controller.impl;

import com.google.gson.Gson;
import com.hiberus.orders.domain.ports.in.GetOrderUseCase;
import com.hiberus.orders.infrastructure.DTO.OrderDTO;
import com.hiberus.orders.infrastructure.adapter.in.web.controller.OrderController;
import com.hiberus.orders.infrastructure.adapter.out.persistence.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class OrderControllerImpl implements OrderController {

    @Autowired
    private GetOrderUseCase getOrderUseCase;

    private Gson gson = new Gson();
    @Override
    public ResponseEntity<?> getOrders() {
        try {
            List<OrderDTO> orderEntityList = getOrderUseCase.getOrders();
          return new ResponseEntity<>(gson.toJson(orderEntityList), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson("Internal server error"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
