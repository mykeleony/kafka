package com.mykeleony.github.paymentservice.domain.service.implementations;

import com.mykeleony.github.paymentservice.domain.model.Payment;
import com.mykeleony.github.paymentservice.domain.service.interfaces.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService implements IPaymentService {
    
    @Override
    public void sendPayment(Payment payment) {
        log.info("PaymentService received the payment {}!", payment);
    }
    
}
