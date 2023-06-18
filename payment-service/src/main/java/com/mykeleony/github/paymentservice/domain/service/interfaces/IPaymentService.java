package com.mykeleony.github.paymentservice.domain.service.interfaces;

import com.mykeleony.github.paymentservice.domain.model.Payment;

public interface IPaymentService {

    void sendPayment(Payment payment);

}
