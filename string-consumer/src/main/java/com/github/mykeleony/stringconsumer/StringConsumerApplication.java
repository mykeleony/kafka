package com.github.mykeleony.stringconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class StringConsumerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StringConsumerApplication.class, args);
    }
    
}
