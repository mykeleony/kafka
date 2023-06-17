package com.github.mykeleony.stringconsumer.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

import java.util.HashMap;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Configuration
@AllArgsConstructor
public class StringConsumerConfig {

    private final KafkaProperties properties;
    private final Logger LOG = LoggerFactory.getLogger(StringConsumerConfig.class);
    
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        HashMap<String, Object> configs = new HashMap<>();
        
        configs.put(BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(configs);
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> stringContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        
        factory.setConsumerFactory(consumerFactory());
        
        return factory;
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> validateMessageContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        
        factory.setConsumerFactory(consumerFactory());
        factory.setRecordInterceptor(validateMessage());
        
        return factory;
    }
    
    private RecordInterceptor<String, String> validateMessage() {
        return (record, consumer) -> {
            if (record.value().contains("Test")) {
                LOG.info("Message contains 'test' word.");
            }
            
            return record;
        };
    }
    
}
