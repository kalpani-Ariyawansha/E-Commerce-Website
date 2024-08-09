package com.SQA.QATestForShop.payment;

import com.SQA.QATestForShop.manageProduct.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    void testDefaultConstructor() {
        Payment payment = new Payment();
        assertNull(payment.getId());
        assertNull(payment.getProduct());
        assertNull(payment.getTotalPrice());
        assertEquals(0, payment.getQuantity());
    }

    @Test
    void testAllArgsConstructor() {
        Product product = new Product(
                "prod123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                null,
                5.00
        );

        Payment payment = new Payment(
                "pay123",
                product,
                99.95,
                5
        );

        assertEquals("pay123", payment.getId());
        assertEquals(product, payment.getProduct());
        assertEquals(99.95, payment.getTotalPrice());
        assertEquals(5, payment.getQuantity());
    }

    @Test
    void testSettersAndGetters() {
        Product product = new Product(
                "prod123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                null,
                5.00
        );

        Payment payment = new Payment();
        payment.setId("pay123");
        payment.setProduct(product);
        payment.setTotalPrice(99.95);
        payment.setQuantity(5);

        assertEquals("pay123", payment.getId());
        assertEquals(product, payment.getProduct());
        assertEquals(99.95, payment.getTotalPrice());
        assertEquals(5, payment.getQuantity());
    }

    @Test
    void testToString() {
        Product product = new Product(
                "prod123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                null,
                5.00
        );

        Payment payment = new Payment(
                "pay123",
                product,
                99.95,
                5
        );

        String expectedString = "Payment(id=pay123, product=" + product + ", totalPrice=99.95, quantity=5)";
        assertEquals(expectedString, payment.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Product product = new Product(
                "prod123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                null,
                5.00
        );

        Payment payment1 = new Payment(
                "pay123",
                product,
                99.95,
                5
        );

        Payment payment2 = new Payment(
                "pay123",
                product,
                99.95,
                5
        );

        assertEquals(payment1, payment2);
        assertEquals(payment1.hashCode(), payment2.hashCode());
    }

    @Test
    void testBuilder() {
        Product product = new Product(
                "prod123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                null,
                5.00
        );

        Payment payment = Payment.builder()
                .id("pay123")
                .product(product)
                .totalPrice(99.95)
                .quantity(5)
                .build();

        assertEquals("pay123", payment.getId());
        assertEquals(product, payment.getProduct());
        assertEquals(99.95, payment.getTotalPrice());
        assertEquals(5, payment.getQuantity());
    }
}
