package com.Entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Payment {

    
    private int pid;
    
    @JsonProperty(value = "TransactionId")
    private String TransactionId;
 
    @JsonProperty(value = "orderId")
    private int orderId;
    
    @JsonProperty(value = "paymentStatus")
    private boolean paymentStatus;
    
    @CreationTimestamp
    private LocalDateTime TransactionTime;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        TransactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Payment [pid=" + pid + ", TransactionId=" + TransactionId + ", orderId=" + orderId + ", paymentStatus="
                + paymentStatus + ", TransactionTime=" + TransactionTime + "]";
    }
    
}
