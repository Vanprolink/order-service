package com.ecommerce.orderservice.model;

import com.ecommerce.common.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orders") // Đặt tên bảng là t_orders để tránh trùng từ khóa SQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber; // Mã đơn hàng (VD: ORD-12345)
    private Long productId;   // ID sản phẩm muốn mua
    private BigDecimal price;   // Giá tại thời điểm mua
    private Integer quantity;   // Số lượng mua
    @Column(name = "sku_code")
    private String skuCode;
    private String email;
    private String status;
}
