package com.hiberus.users.infrastructure.adapter.out.persistence;

import com.hiberus.users.infrastructure.DTO.BuyerDTO;
import com.hiberus.users.infrastructure.DTO.GarmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "clothingAsync",url = "localhost:8083")
public interface GarmentClient {


    @PutMapping(value="/clothing/buy/", produces = "application/json")
    ResponseEntity<GarmentDTO> buy(@RequestBody BuyerDTO buyerDTO);

}
