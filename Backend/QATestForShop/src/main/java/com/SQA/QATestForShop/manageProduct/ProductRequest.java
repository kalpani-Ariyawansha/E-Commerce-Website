package com.SQA.QATestForShop.manageProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private Boolean availability;
    private String category;
    private String brand;
    private String specifications;
    private String warrantyInfo;
    private Double deliveryCharge;

}
