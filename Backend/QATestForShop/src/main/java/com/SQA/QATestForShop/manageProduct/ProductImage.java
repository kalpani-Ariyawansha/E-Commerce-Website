package com.SQA.QATestForShop.manageProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductImage {
    @Id
    private String id;
    private String name;
    private String photoType;
    private byte[] data;
}
