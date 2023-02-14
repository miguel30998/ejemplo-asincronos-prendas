package com.hiberus.clothingAsync.application.services;

import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.ports.in.CreateGarmentUseCase;
import com.hiberus.clothingAsync.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateGarment implements CreateGarmentUseCase {
    private final GarmentPort garmentPort;

    @Override
    public boolean createGarment(Garment garment){
        return garmentPort.createGarment(garment);
    }
}
