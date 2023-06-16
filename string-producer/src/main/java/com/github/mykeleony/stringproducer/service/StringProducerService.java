package com.github.mykeleony.stringproducer.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class StringProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger LOG = LoggerFactory.getLogger(StringProducerService.class);
    
    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("string-topic", message);
        
        // Logging
        future.whenComplete((result, exception) -> {
            RecordMetadata metadata = result.getRecordMetadata();
            
            if (exception == null) {
               LOG.info("Sent message '{}' with offset {} and partition {} successfully!",
                       message, metadata.offset(), metadata.partition());
           } else {
               LOG.error("Unable to send message '{}' due to {}", message, exception.getMessage());
           }
        });
    }
    
}
