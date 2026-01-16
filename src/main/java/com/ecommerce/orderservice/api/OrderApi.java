package com.ecommerce.orderservice.api;

import com.ecommerce.orderservice.client.ProductClient;
import com.ecommerce.orderservice.dto.OrderRequest;
import com.ecommerce.orderservice.dto.OrderResponse;
import com.ecommerce.orderservice.dto.ProductResponse;

import com.ecommerce.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")

public class OrderApi {
    private final ProductClient productClient;
    private final OrderService orderService;

    public OrderApi(ProductClient productClient, OrderService orderService) {
        this.productClient = productClient;
        this.orderService = orderService;
    }

    @GetMapping("/test-feign")
    public String testFeign() {
        // Gọi sang Product Service lấy danh sách
        List<ProductResponse> products = productClient.getAllProducts();

        return "Kết nối thành công! Lấy được " + products.size() + " sản phẩm từ Product Service.";
    }

    @PostMapping("/order-buy")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        // Controller chỉ làm 1 việc: Gọi Service xử lý và trả kết quả về
        return orderService.placeOrder(orderRequest);
    }

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED) // Trả về code 201 khi tạo thành công
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

}
