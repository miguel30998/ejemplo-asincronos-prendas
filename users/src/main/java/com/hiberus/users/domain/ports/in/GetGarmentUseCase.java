package com.hiberus.users.domain.ports.in;

import com.hiberus.users.infrastructure.DTO.BuyerDTO;
import com.hiberus.users.infrastructure.DTO.GarmentDTO;

public interface GetGarmentUseCase {

    GarmentDTO getGarment(BuyerDTO buyerDTO);
}
