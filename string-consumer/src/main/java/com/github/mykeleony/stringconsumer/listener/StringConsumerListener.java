package com.github.mykeleony.stringconsumer.listener;

import com.github.mykeleony.stringconsumer.listener.custom.StringConsumerCustomListener;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StringConsumerListener {

    private final Logger LOG = LoggerFactory.getLogger(StringConsumerListener.class);
    
    @StringConsumerCustomListener(groupId = "group-1")
    @SneakyThrows
    public void create(String message) {
        LOG.info("Received message '{}'", message);
        
        if (message.equals("Exception")) {
            throw new RuntimeException("Exception test!");
        }
    }

}
