package com.hiberus.clothingAsync.application.services;

import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.ports.in.GetGarmentsUseCase;
import com.hiberus.clothingAsync.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class GetGarments implements GetGarmentsUseCase {
    private final GarmentPort garmentPort;

    @Override
    public List<Garment> getGarments() {
        return garmentPort.getListGarment();
    }
}
