package com.SQA.QATestForShop.manageProduct;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testDefaultConstructor() {
        Product product = new Product();
        assertNull(product.getId());
        assertNull(product.getName());
        assertNull(product.getPrice());
        assertNull(product.getDescription());
        assertNull(product.getAvailability());
        assertNull(product.getCategory());
        assertNull(product.getBrand());
        assertNull(product.getSpecifications());
        assertNull(product.getWarrantyInfo());
        assertNull(product.getProductImage());
        assertNull(product.getDeliveryCharge());
    }

    @Test
    void testAllArgsConstructor() {
        Product product = new Product(
                "123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                new ProductImage(),
                5.00
        );

        assertEquals("123", product.getId());
        assertEquals("Product Name", product.getName());
        assertEquals(new BigDecimal("19.99"), product.getPrice());
        assertEquals("Description", product.getDescription());
        assertTrue(product.getAvailability());
        assertEquals("Category", product.getCategory());
        assertEquals("Brand", product.getBrand());
        assertEquals("Specifications", product.getSpecifications());
        assertEquals("Warranty Info", product.getWarrantyInfo());
        assertNotNull(product.getProductImage());
        assertEquals(5.00, product.getDeliveryCharge());
    }

    @Test
    void testSettersAndGetters() {
        Product product = new Product();
        product.setId("123");
        product.setName("Product Name");
        product.setPrice(new BigDecimal("19.99"));
        product.setDescription("Description");
        product.setAvailability(true);
        product.setCategory("Category");
        product.setBrand("Brand");
        product.setSpecifications("Specifications");
        product.setWarrantyInfo("Warranty Info");
        product.setProductImage(new ProductImage());
        product.setDeliveryCharge(5.00);

        assertEquals("123", product.getId());
        assertEquals("Product Name", product.getName());
        assertEquals(new BigDecimal("19.99"), product.getPrice());
        assertEquals("Description", product.getDescription());
        assertTrue(product.getAvailability());
        assertEquals("Category", product.getCategory());
        assertEquals("Brand", product.getBrand());
        assertEquals("Specifications", product.getSpecifications());
        assertEquals("Warranty Info", product.getWarrantyInfo());
        assertNotNull(product.getProductImage());
        assertEquals(5.00, product.getDeliveryCharge());
    }

//    @Test
//    void testToString() {
//        Product product = new Product(
//                "123",
//                "Product Name",
//                new BigDecimal("19.99"),
//                "Description",
//                true,
//                "Category",
//                "Brand",
//                "Specifications",
//                "Warranty Info",
//                new ProductImage(),
//                5.00
//        );
//
//        String expectedString = "Product(id=123, name=Product Name, price=19.99, description=Description, availability=true, category=Category, brand=Brand, specifications=Specifications, warrantyInfo=Warranty Info, productImage=" + product.getProductImage() + ", deliveryCharge=5.00)";
//        assertEquals(expectedString, product.toString());
//    }

    @Test
    void testEqualsAndHashCode() {
        Product product1 = new Product(
                "123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                new ProductImage(),
                5.00
        );

        Product product2 = new Product(
                "123",
                "Product Name",
                new BigDecimal("19.99"),
                "Description",
                true,
                "Category",
                "Brand",
                "Specifications",
                "Warranty Info",
                new ProductImage(),
                5.00
        );

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void testBuilder() {
        Product product = Product.builder()
                .id("123")
                .name("Product Name")
                .price(new BigDecimal("19.99"))
                .description("Description")
                .availability(true)
                .category("Category")
                .brand("Brand")
                .specifications("Specifications")
                .warrantyInfo("Warranty Info")
                .productImage(new ProductImage())
                .deliveryCharge(5.00)
                .build();

        assertEquals("123", product.getId());
        assertEquals("Product Name", product.getName());
        assertEquals(new BigDecimal("19.99"), product.getPrice());
        assertEquals("Description", product.getDescription());
        assertTrue(product.getAvailability());
        assertEquals("Category", product.getCategory());
        assertEquals("Brand", product.getBrand());
        assertEquals("Specifications", product.getSpecifications());
        assertEquals("Warranty Info", product.getWarrantyInfo());
        assertNotNull(product.getProductImage());
        assertEquals(5.00, product.getDeliveryCharge());
    }
}
