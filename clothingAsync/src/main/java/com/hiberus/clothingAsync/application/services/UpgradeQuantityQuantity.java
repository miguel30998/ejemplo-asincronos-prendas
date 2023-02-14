package com.hiberus.clothingAsync.application.services;

import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.ports.in.UpgradeQuantityUseCase;
import com.hiberus.clothingAsync.domain.ports.out.GarmentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpgradeQuantityQuantity implements UpgradeQuantityUseCase {

    private final GarmentPort garmentPort;

    @Override
    public boolean upgrade(Garment garment) {
        garment.setQuantity(garment.getQuantity()+1);
        return garmentPort.createGarment(garment);
    }
}
