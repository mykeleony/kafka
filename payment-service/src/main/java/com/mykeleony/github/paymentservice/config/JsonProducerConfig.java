package com.mykeleony.github.paymentservice.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
@AllArgsConstructor
public class JsonProducerConfig {
    
    private final KafkaProperties properties;
    
    @Bean
    public ProducerFactory jsonProducerFactory() {
        HashMap<String, Object> configs = new HashMap<>();
        
        configs.put(BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        return new DefaultKafkaProducerFactory(configs, new StringSerializer(), new JsonSerializer());
    }
    
    @Bean
    public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory jsonProducerFactory) {
        return new KafkaTemplate<>(jsonProducerFactory);
    }
    
}
