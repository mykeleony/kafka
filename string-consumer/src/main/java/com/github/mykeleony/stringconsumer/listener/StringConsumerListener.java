package com.github.mykeleony.stringconsumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StringConsumerListener {

    private final Logger LOG = LoggerFactory.getLogger(StringConsumerListener.class);
    
    @KafkaListener(groupId = "group-1", topics = "string-topic", containerFactory = "stringContainerFactory")
    public void create(String message) {
        LOG.info("Received message '{}'", message);
    }

}
