package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.OrderDTO;
import com.Entity.Order;
import com.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService os;
    
    @PostMapping("/bookorder")
    public ResponseEntity<?> bookOrder(@RequestBody Order o){
        
        OrderDTO dto = os.bookOrderInService(o);
        
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
