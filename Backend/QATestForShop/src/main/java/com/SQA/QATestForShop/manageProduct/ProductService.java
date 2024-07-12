package com.SQA.QATestForShop.manageProduct;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(MultipartFile photo,ProductRequest productRequest) throws IOException {
        ProductImage productImage = ProductImage.builder()
                .name(photo.getName())
                .data(photo.getBytes())
                .photoType(photo.getContentType())
                .build();
        Product product = Product.builder()
                .specifications(productRequest.getSpecifications())
                .availability(productRequest.getAvailability())
                .brand(productRequest.getBrand())
                .category(productRequest.getCategory())
                .productImage(productImage)
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .warrantyInfo(productRequest.getWarrantyInfo())
                .name(productRequest.getName())
                .build();

        productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProduct(String id){
        return productRepository.findById(id);
    }
    public boolean deleteProduct(String id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
     return false;
    }


    public boolean updateProduct(String id, MultipartFile photo,ProductRequest productRequest) throws IOException {
        Optional<Product> product1 = productRepository.findById(id);
        ProductImage productImage = ProductImage.builder()
                .name(photo.getName())
                .data(photo.getBytes())
                .photoType(photo.getContentType())
                .build();
        if(product1.isPresent()){
            Product product = product1.get();
            if (productRequest.getSpecifications() != null) {
                product.setSpecifications(productRequest.getSpecifications());
            }
            if (productRequest.getAvailability() != null) {
                product.setAvailability(productRequest.getAvailability());
            }
            if (productRequest.getBrand() != null) {
                product.setBrand(productRequest.getBrand());
            }
            if (productRequest.getCategory() != null) {
                product.setCategory(productRequest.getCategory());
            }
            if (productImage != null) {
                product.setProductImage(productImage);
            }
            if (productRequest.getDescription() != null) {
                product.setDescription(productRequest.getDescription());
            }
            if (productRequest.getPrice() != null) {
                product.setPrice(productRequest.getPrice());
            }
            if (productRequest.getWarrantyInfo() != null) {
                product.setWarrantyInfo(productRequest.getWarrantyInfo());
            }
            if (productRequest.getName() != null) {
                product.setName(productRequest.getName());
            }
            productRepository.save(product);
            return true;
        }
        return false;

    }
}
