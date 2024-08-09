package com.SQA.QATestForShop.manageProduct;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductImageTest {

    @Test
    void testDefaultConstructor() {
        ProductImage productImage = new ProductImage();
        assertNull(productImage.getId());
        assertNull(productImage.getName());
        assertNull(productImage.getPhotoType());
        assertNull(productImage.getData());
    }

    @Test
    void testAllArgsConstructor() {
        byte[] data = new byte[]{1, 2, 3};

        ProductImage productImage = new ProductImage(
                "img123",
                "Product Image",
                "jpeg",
                data
        );

        assertEquals("img123", productImage.getId());
        assertEquals("Product Image", productImage.getName());
        assertEquals("jpeg", productImage.getPhotoType());
        assertArrayEquals(data, productImage.getData());
    }

    @Test
    void testSettersAndGetters() {
        byte[] data = new byte[]{1, 2, 3};

        ProductImage productImage = new ProductImage();
        productImage.setId("img123");
        productImage.setName("Product Image");
        productImage.setPhotoType("jpeg");
        productImage.setData(data);

        assertEquals("img123", productImage.getId());
        assertEquals("Product Image", productImage.getName());
        assertEquals("jpeg", productImage.getPhotoType());
        assertArrayEquals(data, productImage.getData());
    }



    @Test
    void testEqualsAndHashCode() {
        byte[] data1 = new byte[]{1, 2, 3};
        byte[] data2 = new byte[]{1, 2, 3};

        ProductImage productImage1 = new ProductImage(
                "img123",
                "Product Image",
                "jpeg",
                data1
        );

        ProductImage productImage2 = new ProductImage(
                "img123",
                "Product Image",
                "jpeg",
                data2
        );

        assertEquals(productImage1, productImage2);
        assertEquals(productImage1.hashCode(), productImage2.hashCode());
    }

    @Test
    void testBuilder() {
        byte[] data = new byte[]{1, 2, 3};

        ProductImage productImage = ProductImage.builder()
                .id("img123")
                .name("Product Image")
                .photoType("jpeg")
                .data(data)
                .build();

        assertEquals("img123", productImage.getId());
        assertEquals("Product Image", productImage.getName());
        assertEquals("jpeg", productImage.getPhotoType());
        assertArrayEquals(data, productImage.getData());
    }
}
