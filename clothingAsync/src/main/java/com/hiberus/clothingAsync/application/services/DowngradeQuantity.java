package com.hiberus.clothingAsync.application.services;

import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.ports.in.DowngradeQuantityUseCase;
import com.hiberus.clothingAsync.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DowngradeQuantity implements DowngradeQuantityUseCase {
    private final GarmentPort garmentPort;

    @Override
    public boolean downgrade(Garment garment) {
        garment.setQuantity(garment.getQuantity()-1);
        return garmentPort.createGarment(garment);
    }


}
