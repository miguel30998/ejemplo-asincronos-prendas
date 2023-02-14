package com.hiberus.users.domain.ports.out;

import com.hiberus.users.infrastructure.DTO.BuyerDTO;
import com.hiberus.users.infrastructure.DTO.GarmentDTO;

public interface GarmentPort {
    GarmentDTO getGarment(BuyerDTO buyerDTO);
}
