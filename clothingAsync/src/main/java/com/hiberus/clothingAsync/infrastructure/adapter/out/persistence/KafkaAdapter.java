package com.hiberus.clothingAsync.infrastructure.adapter.out.persistence;

import com.hiberus.infraestructure.IdCloth;
import com.hiberus.infraestructure.TextCloth;
import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.ports.out.KafkaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAdapter  implements KafkaPort {

    @Autowired
    KafkaTemplate<IdCloth, TextCloth> kafkaTemplate;
    @Override
    public void postBuy(Garment garment,String userId) {
        IdCloth idCloth= new IdCloth(garment.getId());
        TextCloth textCloth= new TextCloth(userId);
        kafkaTemplate.send("orders",idCloth,textCloth);

    }
}
