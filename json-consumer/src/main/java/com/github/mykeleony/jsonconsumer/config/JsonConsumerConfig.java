package com.github.mykeleony.jsonconsumer.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import java.util.HashMap;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Configuration
@AllArgsConstructor
public class JsonConsumerConfig {
    
    private KafkaProperties properties;
    
    @Bean
    public ConsumerFactory<String, Object> jsonConsumerFactory() {
        HashMap<String, Object> configs = new HashMap<>();
        
        configs.put(BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(configs);
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> jsonContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        
        factory.setConsumerFactory(jsonConsumerFactory());
        factory.setRecordMessageConverter(new JsonMessageConverter());
        
        return factory;
    }
    
}
