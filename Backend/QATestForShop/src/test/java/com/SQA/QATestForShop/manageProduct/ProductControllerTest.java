package com.SQA.QATestForShop.manageProduct;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testAddProduct() throws Exception {
        MockMultipartFile photo = new MockMultipartFile("photo", "photo.jpg", MediaType.IMAGE_JPEG_VALUE, "photo".getBytes());
        ProductRequest productRequest = new ProductRequest("Product1", BigDecimal.valueOf(100), "Description", true, "Category1", "Brand1", "Specifications", "Warranty", 500.0);
        String productDetails = new ObjectMapper().writeValueAsString(productRequest);
        MockMultipartFile productDetailsPart = new MockMultipartFile("productDetails", "", "application/json",productDetails.getBytes());

        when(objectMapper.readValue(productDetails, ProductRequest.class)).thenReturn(productRequest);
        doNothing().when(productService).addProduct(any(MultipartFile.class), any(ProductRequest.class));

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/product/add/product")
                        .file(productDetailsPart)
                        .file(photo)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .with(request -> {
                            request.setMethod("POST");
                            return request;
                        }))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllProducts() throws Exception {
        Product product = new Product("1", "Product1", BigDecimal.valueOf(100), "Description", true, "Category1", "Brand1", "Specifications", "Warranty", null,500.0);
        List<Product> productList = Arrays.asList(product);

        when(productService.getProducts()).thenReturn(productList);

        mockMvc.perform(get("/api/v1/product/getAllProducts"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProduct() throws Exception {
        Product product = new Product("1", "Product1", BigDecimal.valueOf(100), "Description", true, "Category1", "Brand1", "Specifications", "Warranty",null, 500.0);
        Optional<Product> optionalProduct = Optional.of(product);

        when(productService.getProduct("1")).thenReturn(optionalProduct);

        mockMvc.perform(get("/api/v1/product/getProduct/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        MockMultipartFile photo = new MockMultipartFile("photo", "photo.jpg", MediaType.IMAGE_JPEG_VALUE, "photo".getBytes());
        ProductRequest productRequest = new ProductRequest("Product1", BigDecimal.valueOf(100), "Description", true, "Category1", "Brand1", "Specifications", "Warranty",500.0);
        String productDetails = new ObjectMapper().writeValueAsString(productRequest);
        MockMultipartFile productDetailsPart = new MockMultipartFile("productDetails", "", "application/json",productDetails.getBytes());

        when(objectMapper.readValue(productDetails, ProductRequest.class)).thenReturn(productRequest);
        when(productService.updateProduct(any(String.class), any(MultipartFile.class), any(ProductRequest.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/product/update/product/{id}", "1")
                        .file(productDetailsPart)
                        .file(photo)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .with(request -> {
                            request.setMethod("PUT");
                            return request;
                        }))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        when(productService.deleteProduct("1")).thenReturn(true);

        mockMvc.perform(delete("/api/v1/product/deleteProduct/1"))
                .andExpect(status().isOk());
    }
}
