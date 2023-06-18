package com.mykeleony.github.paymentservice.api.controller.interfaces;

import com.mykeleony.github.paymentservice.domain.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPaymentController {

    @PostMapping
    ResponseEntity<Payment> pay(@RequestBody Payment payment);

}
