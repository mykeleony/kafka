package com.github.mykeleony.jsonconsumer.listener;

import com.github.mykeleony.jsonconsumer.domain.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.*;

@Component
@Slf4j
public class JsonListener {

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    @SneakyThrows
    public void antiFraud(@Payload Payment payment) {
        log.info("Detecting frauds over payment {}...", payment);
        
        sleep(5000);
        
        log.info("Purchase approved!");
        
        sleep(5000);
    }
    
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    @SneakyThrows
    public void generatePdf(@Payload Payment payment) {
        log.info("Generating PDF file for payment {}...", payment);
        
        sleep(5000);
        
        log.info("PDF file generated successfully!");
    }
    
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    @SneakyThrows
    public void sendEmail(@Payload Payment payment) {
        log.info("Sending confirmation e-mail for payment {}...", payment);
        
        sleep(5000);
        
        log.info("E-mail sent successfully!");
    }

}
