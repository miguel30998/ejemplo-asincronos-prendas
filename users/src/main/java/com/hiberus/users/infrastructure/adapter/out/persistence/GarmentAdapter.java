package com.hiberus.users.infrastructure.adapter.out.persistence;

import com.hiberus.users.domain.ports.out.GarmentPort;
import com.hiberus.users.infrastructure.DTO.BuyerDTO;
import com.hiberus.users.infrastructure.DTO.GarmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GarmentAdapter implements GarmentPort {

    private final GarmentClient garmentClient;

    @Override
    public GarmentDTO getGarment(BuyerDTO buyerDTO) {
        ResponseEntity<?>cloth= garmentClient.buy(buyerDTO);
        if(cloth.getStatusCode().is2xxSuccessful()){
            return (GarmentDTO) cloth.getBody();
        }
        if(cloth.getStatusCode().is4xxClientError()){
            throw new RuntimeException("Garment not found");
        }
        if(cloth.getStatusCode().is5xxServerError()){
            throw new RuntimeException("Internal server error");
        }
        throw new RuntimeException();
    }
}
