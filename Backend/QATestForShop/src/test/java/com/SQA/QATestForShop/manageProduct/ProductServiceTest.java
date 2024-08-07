package com.SQA.QATestForShop.manageProduct;

import com.SQA.QATestForShop.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() throws IOException {
        MultipartFile photo = mock(MultipartFile.class);
        ProductRequest productRequest = mock(ProductRequest.class);

        when(photo.getName()).thenReturn("photoName");
        when(photo.getBytes()).thenReturn(new byte[0]);
        when(photo.getContentType()).thenReturn("image/jpeg");

        when(productRequest.getName()).thenReturn("Test Product");
        when(productRequest.getPrice()).thenReturn(BigDecimal.valueOf(99.99));
        when(productRequest.getDescription()).thenReturn("Test Description");
        when(productRequest.getAvailability()).thenReturn(true);
        when(productRequest.getCategory()).thenReturn("Test Category");
        when(productRequest.getBrand()).thenReturn("Test Brand");
        when(productRequest.getSpecifications()).thenReturn("Test Specifications");
        when(productRequest.getWarrantyInfo()).thenReturn("Test Warranty");
        when(productRequest.getDeliveryCharge()).thenReturn(500.0);

        productService.addProduct(photo, productRequest);

        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testGetProducts() {
        productService.getProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProduct() {
        String productId = "123";
        productService.getProduct(productId);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testDeleteProduct() {
        String productId = "123";
        when(productRepository.findById(productId)).thenReturn(Optional.of(new Product()));

        boolean result = productService.deleteProduct(productId);

        assertTrue(result);
        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void testDeleteProduct_NotFound() {
        String productId = "123";
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        boolean result = productService.deleteProduct(productId);

        assertFalse(result);
        verify(productRepository, never()).deleteById(anyString());
    }

    @Test
    void testUpdateProduct() throws IOException {
        String productId = "123";
        MultipartFile photo = mock(MultipartFile.class);
        ProductRequest productRequest = mock(ProductRequest.class);


        when(productRequest.getName()).thenReturn("Test Product");
        when(productRequest.getPrice()).thenReturn(BigDecimal.valueOf(99.99));
        when(productRequest.getDescription()).thenReturn("Test Description");
        when(productRequest.getAvailability()).thenReturn(true);
        when(productRequest.getCategory()).thenReturn("Test Category");
        when(productRequest.getBrand()).thenReturn("Test Brand");
        when(productRequest.getSpecifications()).thenReturn("Test Specifications");
        when(productRequest.getWarrantyInfo()).thenReturn("Test Warranty");
        when(productRequest.getDeliveryCharge()).thenReturn(500.0);
        when(photo.getName()).thenReturn("photoName");
        when(photo.getBytes()).thenReturn(new byte[0]);
        when(photo.getContentType()).thenReturn("image/jpeg");

        ProductImage productImage = ProductImage.builder()
                .name(photo.getName())
                .data(photo.getBytes())
                .photoType(photo.getContentType())
                .build();

        Product existingProduct = Product.builder()
                .specifications(productRequest.getSpecifications())
                .availability(productRequest.getAvailability())
                .brand(productRequest.getBrand())
                .category(productRequest.getCategory())
                .productImage(productImage)
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .warrantyInfo(productRequest.getWarrantyInfo())
                .name(productRequest.getName())
                .deliveryCharge(productRequest.getDeliveryCharge())
                .build();

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));


        boolean result = productService.updateProduct(productId, photo, productRequest);
        assertTrue(result);

        verify(productRepository, times(1)).save(existingProduct);

        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());
        Product product = productArgumentCaptor.getValue();

        assertNotNull(product);
        assertEquals("Test Product", product.getName());
        assertEquals(BigDecimal.valueOf(99.99), product.getPrice());
        assertEquals("Test Description", product.getDescription());
        assertEquals(true, product.getAvailability());
        assertEquals("Test Category", product.getCategory());
        assertEquals("Test Brand", product.getBrand());
        assertEquals("Test Specifications", product.getSpecifications());
        assertEquals("Test Warranty", product.getWarrantyInfo());
        assertEquals(500.0,product.getDeliveryCharge());
    }

    @Test
    void testUpdateProduct_NotFound() throws IOException {
        String productId = "123";
        MultipartFile photo = mock(MultipartFile.class);
        ProductRequest productRequest = mock(ProductRequest.class);

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        boolean result = productService.updateProduct(productId, photo, productRequest);

        assertFalse(result);
        verify(productRepository, never()).save(any(Product.class));
    }
}

