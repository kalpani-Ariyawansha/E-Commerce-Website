package com.SQA.QATestForShop.payment;

import com.SQA.QATestForShop.manageProduct.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    @Id
    private String id;
    private Product product;
    private Double totalPrice;
    private int quantity;
}
