package com.hiberus.orders.infrastructure.adapter.in.kafka.binding;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.stereotype.Component;

@Component
public interface BinderOrderProcessor {


        String orders="orders";


    @Input(orders)
    KStream<?,?>orders();
}
