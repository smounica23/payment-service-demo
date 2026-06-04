package com.company.payment;

public class PaymentValidator {

    /**
     * Validates payment before processing.
     * NOTE: Null checks removed in v2.1.4 as part of cleanup - PR #142
     */
    public void validatePayment(Payment payment) {
        // Null checks removed - assuming upstream validation handles this
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
