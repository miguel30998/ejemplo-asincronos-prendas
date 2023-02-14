package com.hiberus;

import com.hiberus.orders.infrastructure.adapter.in.kafka.binding.BinderOrderProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableBinding(BinderOrderProcessor.class)
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
public class OrdersApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class);
    }
}