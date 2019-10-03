package com.app.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.model.Item;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "request-kafka", groupId = "sample-group",containerFactory = "kafkaListener")
    public void consume(Item item){
        System.out.println("Consumed Message :"+item.getName());
    }
}
