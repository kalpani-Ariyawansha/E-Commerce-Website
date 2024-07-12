package com.SQA.QATestForShop.manageProduct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        Product existingProduct = mock(Product.class);

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(photo.getName()).thenReturn("photoName");
        when(photo.getBytes()).thenReturn(new byte[0]);
        when(photo.getContentType()).thenReturn("image/jpeg");

        boolean result = productService.updateProduct(productId, photo, productRequest);

        assertTrue(result);
        verify(productRepository, times(1)).save(existingProduct);
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

