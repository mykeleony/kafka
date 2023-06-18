package com.mykeleony.github.paymentservice.api.controller.implementations;

import com.mykeleony.github.paymentservice.api.controller.interfaces.IPaymentController;
import com.mykeleony.github.paymentservice.domain.model.Payment;
import com.mykeleony.github.paymentservice.domain.service.interfaces.IPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController implements IPaymentController {
    
    private final IPaymentService paymentService;
    
    @Override
    public ResponseEntity<Payment> pay(Payment payment) {
        paymentService.sendPayment(payment);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
    
}
