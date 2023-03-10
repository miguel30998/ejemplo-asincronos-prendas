package com.hiberus.clothingAsync.infrastructure.adapter.in.web.controller;

import com.hiberus.clothingAsync.domain.model.Size;
import com.hiberus.clothingAsync.infrastructure.DTO.BuyerDTO;
import com.hiberus.clothingAsync.infrastructure.DTO.GarmentDTO;
import com.hiberus.clothingAsync.infrastructure.DTO.GarmentIdentifierDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

@RestController
public interface ClothingController {

    @ApiOperation(value="Crear una prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creada con exito"),
            @ApiResponse(code = 400, message = "Ya existe"),
            @ApiResponse(code = 400, message = "Error al crear")
    })
    @PostMapping(value="/clothing", produces = "application/json")
    ResponseEntity<String> createGarment(@RequestBody GarmentDTO garment);

    @ApiOperation(value="Eliminar una prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Eliminada con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error al eliminar")
    })
    @DeleteMapping(value="/clothing", produces = "application/json")
    ResponseEntity<String> deleteGarment(@RequestBody GarmentIdentifierDTO garment);

    @ApiOperation(value="Obtener todas las prendas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenidas con exito"),
            @ApiResponse(code = 400, message = "Error al obtener"),
    })
    @GetMapping(value="/clothing", produces = "application/json")
    ResponseEntity<String> getClothing();

    @ApiOperation(value="Obtener prenda por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenidas con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error obteniendo prenda")

    })
    @GetMapping(value="/clothing/garment/{garmentId}", produces = "application/json")
    ResponseEntity<String> getClothing(@RequestParam("garmentId")String garmentId);

    @ApiOperation(value="Actualizar cantidad de prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Actualizado con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error obteniendo prenda")

    })
    @PutMapping(value="/clothing/upgrade_quantity", produces = "application/json")
    ResponseEntity<String> upgradeQuantity(@RequestBody GarmentIdentifierDTO garmentIdentifierDTO);

    @ApiOperation(value="Actualizar cantidad de prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Actualizado con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error"),
            @ApiResponse(code = 400, message = "Cantidad insuficiente")

    })
    @PutMapping(value="/clothing/downgrade_quantity", produces = "application/json")
    ResponseEntity<String> downgradeQuantity(@RequestBody GarmentIdentifierDTO garmentIdentifierDTO);

    @ApiOperation(value="Realizar una compra")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Articulo comprado con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error"),
            @ApiResponse(code = 400, message = "Cantidad insuficiente")

    })
    @PutMapping(value="/clothing/buy/", produces = "application/json")
    ResponseEntity<String> buy(@RequestBody BuyerDTO buyerDTO);

}
