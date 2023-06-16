package com.github.mykeleony.stringproducer.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StringProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public void sendMessage(String message) {
        kafkaTemplate.send("string-topic", message);
    }
    
}
