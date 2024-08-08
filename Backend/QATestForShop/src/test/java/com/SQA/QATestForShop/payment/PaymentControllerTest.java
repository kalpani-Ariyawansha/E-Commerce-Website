package com.SQA.QATestForShop.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSavePayment_Success() {
        PaymentRequest paymentRequest = new PaymentRequest();
        doNothing().when(paymentService).savePayment(anyString(), anyString(), eq(paymentRequest));

        ResponseEntity<String> response = paymentController.savePayment("product1", "user1", paymentRequest);

        assertEquals("Payment saved successfully.", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(paymentService, times(1)).savePayment("product1", "user1", paymentRequest);
    }

    @Test
    void testSavePayment_Failure() {
        PaymentRequest paymentRequest = new PaymentRequest();
        doThrow(new RuntimeException("Error")).when(paymentService).savePayment(anyString(), anyString(), eq(paymentRequest));

        ResponseEntity<String> response = paymentController.savePayment("product1", "user1", paymentRequest);

        assertEquals(500, response.getStatusCodeValue());
        verify(paymentService, times(1)).savePayment("product1", "user1", paymentRequest);
    }

    @Test
    void testGetAllPayments_Success() {
        List<Payment> payments = Collections.singletonList(new Payment());
        when(paymentService.getAllProducts(anyString())).thenReturn(payments);

        ResponseEntity<List<Payment>> response = paymentController.getAllPayments("user1");

        assertEquals(payments, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(paymentService, times(1)).getAllProducts("user1");
    }

    @Test
    void testGetAllPayments_NoContent() {
        when(paymentService.getAllProducts(anyString())).thenReturn(Collections.emptyList());

        ResponseEntity<List<Payment>> response = paymentController.getAllPayments("user1");

        assertEquals(204, response.getStatusCodeValue());
        verify(paymentService, times(1)).getAllProducts("user1");
    }

    @Test
    void testGetPayment_Success() {
        Payment payment = new Payment();
        when(paymentService.getPayment(anyString())).thenReturn(payment);

        ResponseEntity<Payment> response = paymentController.getPayment("payment1");

        assertEquals(payment, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(paymentService, times(1)).getPayment("payment1");
    }

    @Test
    void testGetPayment_NotFound() {
        when(paymentService.getPayment(anyString())).thenReturn(null);

        ResponseEntity<Payment> response = paymentController.getPayment("payment1");

        assertEquals(404, response.getStatusCodeValue());
        verify(paymentService, times(1)).getPayment("payment1");
    }

}
