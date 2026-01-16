package com.ecommerce.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {
		"com.ecommerce.orderservice", // Quét code của project hiện tại
		"com.ecommerce.common"        // <--- Quét thêm code của common-library
})
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditorProvider") // Bật Auditing ở đây
@EntityScan({
		"com.ecommerce.orderservice.model", // Quét Entity của project
		"com.ecommerce.common.audit"        // <--- Quét BaseEntity trong thư viện
})
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}
}
