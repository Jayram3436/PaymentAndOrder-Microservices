package com.Service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entity.Payment;
import com.Repo.PaymentRepo;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo pr;
    
    public Payment doPaymentInService(Payment payment) {
        
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(true);
        
        return pr.save(payment);
    }

}
