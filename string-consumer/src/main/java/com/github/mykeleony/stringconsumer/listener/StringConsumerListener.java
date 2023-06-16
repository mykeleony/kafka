package com.github.mykeleony.stringconsumer.listener;

import com.github.mykeleony.stringconsumer.listener.custom.StringConsumerCustomListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class StringConsumerListener {

    private final Logger LOG = LoggerFactory.getLogger(StringConsumerListener.class);
    
    @StringConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        LOG.info("Received message '{}'", message);
    }

}
