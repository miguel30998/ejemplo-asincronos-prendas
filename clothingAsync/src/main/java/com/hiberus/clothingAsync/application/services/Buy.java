package com.hiberus.clothingAsync.application.services;

import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.ports.in.BuyUseCase;
import com.hiberus.clothingAsync.domain.ports.out.GarmentPort;
import com.hiberus.clothingAsync.domain.ports.out.KafkaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class Buy implements BuyUseCase {

    private final KafkaPort kafkaPort;

    private final GarmentPort garmentPort;
    @Override
    public void buy(Garment garment, String userId) {
        garment.setQuantity(garment.getQuantity()-1);
        garmentPort.createGarment(garment);
        kafkaPort.postBuy(garment,userId);
    }
}
