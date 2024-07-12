package com.SQA.QATestForShop.manageProduct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @PostMapping("/add/product")
    public ResponseEntity<?> addProduct(@RequestPart("photo")MultipartFile photo,@RequestPart("productDetails") String productDetails) throws JsonProcessingException {
        ProductRequest productRequest = objectMapper.readValue(productDetails,ProductRequest.class);
        try{
            productService.addProduct(photo,productRequest);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/getAllProducts")
    public  ResponseEntity<?> getAllProducts(){
        try {
            List<Product> products =productService.getProducts();
            return ResponseEntity.ok(products);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getProduct/{id}")
    public  ResponseEntity<?> getProduct(@PathVariable String id){
        try {
            Optional<Product> product =productService.getProduct(id);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestPart("photo")MultipartFile photo,@RequestPart("productDetails") String productDetails,@PathVariable String id) throws JsonProcessingException {
        ProductRequest productRequest = objectMapper.readValue(productDetails,ProductRequest.class);
        try{
            if(productService.updateProduct(id,photo,productRequest)){
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.badRequest().build();
            }

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/deleteProduct/{id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable String id){
        try {
            if(productService.deleteProduct(id)){
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.badRequest().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
