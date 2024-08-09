package com.SQA.QATestForShop.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRequestTest {

    @Test
    void testDefaultConstructor() {
        PaymentRequest paymentRequest = new PaymentRequest();
        assertEquals(0, paymentRequest.getQuantity());
    }

    @Test
    void testAllArgsConstructor() {
        PaymentRequest paymentRequest = new PaymentRequest(10);
        assertEquals(10, paymentRequest.getQuantity());
    }

    @Test
    void testSettersAndGetters() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setQuantity(15);
        assertEquals(15, paymentRequest.getQuantity());
    }

    @Test
    void testToString() {
        PaymentRequest paymentRequest = new PaymentRequest(10);
        String expectedString = "PaymentRequest(quantity=10)";
        assertEquals(expectedString, paymentRequest.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        PaymentRequest paymentRequest1 = new PaymentRequest(10);
        PaymentRequest paymentRequest2 = new PaymentRequest(10);

        assertEquals(paymentRequest1, paymentRequest2);
        assertEquals(paymentRequest1.hashCode(), paymentRequest2.hashCode());
    }

    @Test
    void testBuilder() {
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .quantity(20)
                .build();

        assertEquals(20, paymentRequest.getQuantity());
    }
}
