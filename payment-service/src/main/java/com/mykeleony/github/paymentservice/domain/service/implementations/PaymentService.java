package com.mykeleony.github.paymentservice.domain.service.implementations;

import com.mykeleony.github.paymentservice.domain.model.Payment;
import com.mykeleony.github.paymentservice.domain.service.interfaces.IPaymentService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Slf4j
@AllArgsConstructor
public class PaymentService implements IPaymentService {
    
    private KafkaTemplate<String, Serializable> kafkaTemplate;
    
    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
        log.info("PaymentService received the payment {}!", payment);
        
        Thread.sleep(1000);
        
        log.info("Sending payment...");
        
        kafkaTemplate.send("payment-topic", payment);
    }
    
}
