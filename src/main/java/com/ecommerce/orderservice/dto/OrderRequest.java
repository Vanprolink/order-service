package com.ecommerce.orderservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
    @Column(name = "sku_code")
    private String skuCode;
    private String email;
    private String status;
}
