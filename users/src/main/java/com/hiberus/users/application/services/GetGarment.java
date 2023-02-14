package com.hiberus.users.application.services;

import com.hiberus.users.domain.ports.in.GetGarmentUseCase;
import com.hiberus.users.domain.ports.out.GarmentPort;
import com.hiberus.users.infrastructure.DTO.BuyerDTO;
import com.hiberus.users.infrastructure.DTO.GarmentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class GetGarment implements GetGarmentUseCase {

    private final GarmentPort garmentPort;

    @Override
    public GarmentDTO getGarment(BuyerDTO buyerDTO) {
        return garmentPort.getGarment(buyerDTO);
    }
}
