package com.github.mykeleony.stringconsumer.exception;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomErrorHandler implements KafkaListenerErrorHandler {
    
    private final Logger LOG = LoggerFactory.getLogger(CustomErrorHandler.class);
    
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        LOG.info("CUSTOM_ERROR_HANDLER ::: I've captured an error!");
        
        LOG.info("*** USEFUL INFORMATION ***");
        LOG.info("PAYLOAD ::: {}", message.getPayload());
        LOG.info("HEADERS ::: {}", message.getHeaders());
        LOG.info("Message offset ::: {}", message.getHeaders().get("kafka_offset"));
        LOG.info("Exception message ::: {}", e.getMessage());
        
        return null;
    }
}
