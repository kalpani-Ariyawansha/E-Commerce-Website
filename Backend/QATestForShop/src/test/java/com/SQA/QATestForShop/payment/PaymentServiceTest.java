package com.SQA.QATestForShop.payment;

import com.SQA.QATestForShop.User.User;
import com.SQA.QATestForShop.User.UserRepository;
import com.SQA.QATestForShop.manageProduct.Product;
import com.SQA.QATestForShop.manageProduct.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    private User user;
    private Product product;
    private PaymentRequest paymentRequest;

    @BeforeEach
    void setUp() {
        user = new User();
        product = new Product();
        product.setPrice(BigDecimal.valueOf(100.00));
        product.setDeliveryCharge(10.0);
        paymentRequest = new PaymentRequest();
        paymentRequest.setQuantity(2);
    }

    @Test
    void testSavePayment() {
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
        when(productRepository.findById(anyString())).thenReturn(Optional.of(product));

        paymentService.savePayment("productID", "userID", paymentRequest);

        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentRepository, times(1)).save(paymentCaptor.capture());
        Payment savedPayment = paymentCaptor.getValue();

        assertEquals(product, savedPayment.getProduct());
        assertEquals(paymentRequest.getQuantity(), savedPayment.getQuantity());
        assertEquals(210.0, savedPayment.getTotalPrice());

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertEquals(1, savedUser.getPayments().size());
        assertEquals(savedPayment, savedUser.getPayments().get(0));
    }

    @Test
    void testCalTotalPrice() {
        Double totalPrice = paymentService.calTotalPrice(BigDecimal.valueOf(100.00), 2, 10.0);
        assertEquals(210.0, totalPrice);
    }

    @Test
    void testGetAllProducts() {
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        user.setPayments(Arrays.asList(payment1, payment2));
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));

        assertEquals(2, paymentService.getAllProducts("userID").size());
    }

    @Test
    void testGetAllProducts_UserNotFound() {
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        assertNull(paymentService.getAllProducts("userID"));
    }

    @Test
    void testGetPayment() {
        Payment payment = new Payment();
        when(paymentRepository.findById(anyString())).thenReturn(Optional.of(payment));

        assertEquals(payment, paymentService.getPayment("paymentID"));
    }

    @Test
    void testGetPayment_PaymentNotFound() {
        when(paymentRepository.findById(anyString())).thenReturn(Optional.empty());

        assertNull(paymentService.getPayment("paymentID"));
    }
}
