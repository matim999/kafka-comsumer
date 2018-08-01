package com.comarch.kafkacomsumer.listener;

import com.comarch.kafkacomsumer.model.Car;
import com.comarch.kafkacomsumer.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class KafkaConsumer {
    private static final ObjectMapper mapper = new ObjectMapper();

//    @KafkaListener(topics = "test", groupId = "group_json",
//            containerFactory = "byteKafkaListenerFactory")
//    public void consumeCar(String message) {
//        System.out.println(message);
//    }

    @KafkaListener(id = "id_2", topics = "test", groupId = "group_json",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeUser(ConsumerRecord message) {
        System.out.println(message.toString().split("key")[0]);
    }

//    @KafkaListener(topics = "test2", groupId = "group_json2",
//            containerFactory = "userKafkaListenerFactory")
//    public void consume(User message) {
//        System.out.println(message);
//    }
}
