package com.groupeonepoint.abrahime.eshopping.controllers;

import com.groupeonepoint.abrahime.eshopping.models.Order;
import com.groupeonepoint.abrahime.eshopping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.ok().body(orderService.getAllOrder());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable long id){
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.ok().body(this.orderService.createOrder(order));

    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable long id, @RequestBody Order order){
        order.setOrderId(id);
        return ResponseEntity.ok().body(this.orderService.updateOrder(order));
    }

    @DeleteMapping("orders/{id}")
    public HttpStatus deleteOrder(@PathVariable long id){
        this.orderService.deleteOrder(id);
        //return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
        return HttpStatus.OK;
    }



}
