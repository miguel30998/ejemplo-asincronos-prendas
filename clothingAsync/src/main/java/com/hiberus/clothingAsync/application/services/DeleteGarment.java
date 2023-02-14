package com.hiberus.clothingAsync.application.services;

import com.hiberus.clothingAsync.domain.model.Size;
import com.hiberus.clothingAsync.domain.ports.in.DeleteGarmentUseCase;
import com.hiberus.clothingAsync.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DeleteGarment implements DeleteGarmentUseCase {
    private final GarmentPort garmentPort;

    @Override
    public boolean deleteGarment(String name, Size size) {
        return garmentPort.deleteGarment(name,size);
    }
}
