package com.SQA.QATestForShop.manageProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private Boolean availability;
    private String category;
    private String brand;
    private String specifications;
    private String warrantyInfo;
    private ProductImage productImage;
}
