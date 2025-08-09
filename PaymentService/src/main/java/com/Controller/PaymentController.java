package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Entity.Payment;
import com.Service.PaymentService;

@RestController
public class PaymentController {
    
    @Autowired
    private PaymentService ps;
    
    @PostMapping("/dopayment")
    public ResponseEntity<?> doPayment(@RequestBody Payment payment){
        
       Payment paymentDone=ps.doPaymentInService(payment);
       
       return new ResponseEntity<>(paymentDone,HttpStatus.OK);
    }
}