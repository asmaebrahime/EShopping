package com.groupeonepoint.abrahime.eshopping.services;

import com.groupeonepoint.abrahime.eshopping.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrder(Order order);
    List <Order> getAllOrder();
    Order getOrderById(long orderId);
    void deleteOrder(long orderId);

}
