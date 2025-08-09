package com.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.Entity.Payment;

@FeignClient(name="PaymentService")
public interface PaymentServiceFeignClient {

	@PostMapping("/dopayment")
	Payment callDoPayment(@RequestBody Payment payment);
}
