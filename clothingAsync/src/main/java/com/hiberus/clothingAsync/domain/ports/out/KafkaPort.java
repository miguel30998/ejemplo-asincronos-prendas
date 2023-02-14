package com.hiberus.clothingAsync.domain.ports.out;

import com.hiberus.clothingAsync.domain.model.Garment;

public interface KafkaPort {


    void postBuy(Garment garment,String userId);
}
