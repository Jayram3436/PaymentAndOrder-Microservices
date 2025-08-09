package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Entity.Payment;
import com.DTO.OrderDTO;
import com.Entity.Order;
import com.Repo.OrderRepo;
import com.config.PaymentServiceFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

    @Autowired
    private OrderRepo or;
    
    @Autowired
    private RestTemplate rt;
    
    @Autowired
    private PaymentServiceFeignClient psfc;
     
    public OrderService(PaymentServiceFeignClient psfc) {
		this.psfc = psfc;
	}


    @CircuitBreaker(name="paymentServiceCB",fallbackMethod = "handlePayment")
	public OrderDTO bookOrderInService(Order o) {
        
    	OrderDTO dto = new OrderDTO();
    	
//    	  -----------------------------RestTemplate----------------------------------
//        String url = "http://localhost:9006/dopayment";
//        Payment p = new Payment();
//        p.setOrderId(o.getOid());
//        HttpEntity<Payment> entity = new HttpEntity<Payment>(p);
//        ResponseEntity<Payment> paymentWholeData = rt.exchange(url, HttpMethod.POST, entity, Payment.class);
//        Payment body  = paymentWholeData.getBody();
    	
//    	-----------------------------FeignClient----------------------------------
    	  Payment p = new Payment();
          p.setOrderId(o.getOid());
          
          Payment body =psfc.callDoPayment(p);
        
        if(body.isPaymentStatus()) {
        	
        	dto.setMsg("Order placed!!!");
        	dto.setTransactionId(body.getTransactionId());
        	or.save(o);
        	return dto;
        }
        
        dto.setMsg("Payment Failed!!");
        return dto;
    }
    
    public OrderDTO handlePayment(Order o,Throwable t) {
		OrderDTO dto = new OrderDTO();
		dto.setMsg("Payment Service is down!!!!");
    	return dto;
    }

}
