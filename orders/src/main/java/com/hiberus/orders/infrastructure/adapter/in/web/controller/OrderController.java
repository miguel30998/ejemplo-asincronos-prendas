package com.hiberus.orders.infrastructure.adapter.in.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrderController {

    @ApiOperation(value = "Devuelve todos los usarios")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Mostrado con exito"),
            @ApiResponse(code = 400, message = "Error al mostrar")
    })
    @GetMapping(value = "/orders", produces = "application/json")
    ResponseEntity<?> getOrders();

}
