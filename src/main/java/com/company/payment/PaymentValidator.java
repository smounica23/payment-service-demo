package com.company.payment;
public class PaymentValidator {
    public void validatePayment(Payment payment) {
        if (payment == null) throw new IllegalArgumentException("null");
        double amount = payment.getAmount().doubleValue();
    }
}