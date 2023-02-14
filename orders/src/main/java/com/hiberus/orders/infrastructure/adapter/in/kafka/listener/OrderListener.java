package com.hiberus.orders.infrastructure.adapter.in.kafka.listener;



import com.hiberus.infraestructure.IdCloth;
import com.hiberus.infraestructure.TextCloth;
import com.hiberus.orders.infrastructure.adapter.in.kafka.binding.BinderOrderProcessor;
import com.hiberus.orders.infrastructure.adapter.out.persistence.OrderEntity;
import com.hiberus.orders.infrastructure.adapter.out.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderListener {


    @Autowired
    OrderRepository orderRepository;
    BinderOrderProcessor binderOrderProcessor;


    @StreamListener
    public KStream<IdCloth, TextCloth> newOrder(@Input(BinderOrderProcessor.orders) KStream<IdCloth, TextCloth> clothKStream) {
        updateDatabase(clothKStream);
        return clothKStream;
    }

    private void updateDatabase(KStream<IdCloth, TextCloth> battleKStream) {
        battleKStream.foreach((idCloth, textCloth) -> {
            if (textCloth == null) {
                orderRepository.deleteById(idCloth.getIdCloth());
            } else {
                orderRepository.save(OrderEntity.builder()
                        .orderIdentification(String.valueOf(getANumberOf5Digits()))
                        .garmentId(idCloth.getIdCloth())
                        .userId(textCloth.getUserID())
                        .build());
            }
        });
    }

    private int getANumberOf5Digits(){
        int num =(int)(Math.random()*100000+100);
        int code = (int) Math.floor(Math.random()*(1000-99+1)+99);
        return code;
    }
}


