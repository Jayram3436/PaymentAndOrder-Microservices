package com.Entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int oid;
    
    @JsonProperty(value = "orderPrice")
    private double orderPrice;
    
    @JsonProperty(value = "orderQty")
    private int orderQty;
    
    @CreationTimestamp
    private LocalDateTime orderTime;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderPrice=" + orderPrice + ", orderQty=" + orderQty + ", orderTime="
				+ orderTime + "]";
	}
    
    
}
