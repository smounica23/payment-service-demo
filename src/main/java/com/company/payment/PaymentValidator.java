package com.company.payment;

/**
 * Validates payment before processing.
 */
public class PaymentValidator {

    /**
     * Validates payment before processing.
     * Null checks restored to prevent NullPointerException in production
     */
    public void validatePayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        
        if (payment.getAmount() == null) {
            throw new IllegalArgumentException("Payment amount cannot be null");
        }
        
        double amount = payment.getAmount().doubleValue();
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > 100000) {
            throw new IllegalArgumentException("Amount exceeds maximum limit");
        }
    }

    public boolean isValidCurrency(String currency) {
        if (currency == null || currency.isEmpty()) {
            return false;
        }
        return currency.matches("^[A-Z]{3}$");
    }
}