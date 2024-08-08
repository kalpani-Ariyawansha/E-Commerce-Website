package com.SQA.QATestForShop.manageProduct;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRequestTest {

    @Test
    void testDefaultConstructor() {
        ProductRequest productRequest = new ProductRequest();
        assertNull(productRequest.getName());
        assertNull(productRequest.getPrice());
        assertNull(productRequest.getDescription());
        assertNull(productRequest.getAvailability());
        assertNull(productRequest.getCategory());
        assertNull(productRequest.getBrand());
        assertNull(productRequest.getSpecifications());
        assertNull(productRequest.getWarrantyInfo());
        assertNull(productRequest.getDeliveryCharge());
    }

    @Test
    void testAllArgsConstructor() {
        ProductRequest productRequest = new ProductRequest(
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                5.00
        );

        assertEquals("Product Name", productRequest.getName());
        assertEquals(new BigDecimal("19.99"), productRequest.getPrice());
        assertEquals("Description", productRequest.getDescription());
        assertTrue(productRequest.getAvailability());
        assertEquals("Category", productRequest.getCategory());
        assertEquals("Brand", productRequest.getBrand());
        assertEquals("Specifications", productRequest.getSpecifications());
        assertEquals("Warranty Info", productRequest.getWarrantyInfo());
        assertEquals(5.00, productRequest.getDeliveryCharge());
    }

    @Test
    void testSettersAndGetters() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Product Name");
        productRequest.setPrice(new BigDecimal("19.99"));
        productRequest.setDescription("Description");
        productRequest.setAvailability(true);
        productRequest.setCategory("Category");
        productRequest.setBrand("Brand");
        productRequest.setSpecifications("Specifications");
        productRequest.setWarrantyInfo("Warranty Info");
        productRequest.setDeliveryCharge(5.00);

        assertEquals("Product Name", productRequest.getName());
        assertEquals(new BigDecimal("19.99"), productRequest.getPrice());
        assertEquals("Description", productRequest.getDescription());
        assertTrue(productRequest.getAvailability());
        assertEquals("Category", productRequest.getCategory());
        assertEquals("Brand", productRequest.getBrand());
        assertEquals("Specifications", productRequest.getSpecifications());
        assertEquals("Warranty Info", productRequest.getWarrantyInfo());
        assertEquals(5.00, productRequest.getDeliveryCharge());
    }

    @Test
    void testEqualsAndHashCode() {
        ProductRequest productRequest1 = new ProductRequest(
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                5.00
        );

        ProductRequest productRequest2 = new ProductRequest(
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                5.00
        );

        assertEquals(productRequest1, productRequest2);
        assertEquals(productRequest1.hashCode(), productRequest2.hashCode());
    }

    @Test
    void testBuilder() {
        ProductRequest productRequest = ProductRequest.builder()
                .name("Product Name")
                .price(new BigDecimal("19.99"))
                .description("Description")
                .availability(true)
                .category("Category")
                .brand("Brand")
                .specifications("Specifications")
                .warrantyInfo("Warranty Info")
                .deliveryCharge(5.00)
                .build();

        assertEquals("Product Name", productRequest.getName());
        assertEquals(new BigDecimal("19.99"), productRequest.getPrice());
        assertEquals("Description", productRequest.getDescription());
        assertTrue(productRequest.getAvailability());
        assertEquals("Category", productRequest.getCategory());
        assertEquals("Brand", productRequest.getBrand());
        assertEquals("Specifications", productRequest.getSpecifications());
        assertEquals("Warranty Info", productRequest.getWarrantyInfo());
        assertEquals(5.00, productRequest.getDeliveryCharge());
    }
}
