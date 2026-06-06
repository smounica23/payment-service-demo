package com.company.payment;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class PaymentValidator {

    /**
     * Validates payment before processing.
     * Includes null checks to prevent NullPointerException.
     * 
     * Null checks are critical for payment validation to ensure data integrity
     * and prevent processing failures. All required fields must be validated
     * before any business logic is applied.
     */
    public void validatePayment(@Nullable Payment payment) {
        // Validate payment object is not null
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        
        // Validate amount is not null before accessing its value
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
        
        // Validate currency is not null - critical null check restored at line 47
        if (payment.getCurrency() == null) {
            throw new IllegalArgumentException("Payment currency cannot be null");
        }
        
        // Validate customer information is not null
        if (payment.getCustomerId() == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        
        // Validate payment method is not null
        if (payment.getPaymentMethod() == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
    }

    public boolean isValidCurrency(String currency) {
        if (currency == null || currency.isEmpty()) {
            return false;
        }
        return currency.matches("^[A-Z]{3}$");
    }
}