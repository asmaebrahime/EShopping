package com.groupeonepoint.abrahime.eshopping.services;

import com.groupeonepoint.abrahime.eshopping.exceptions.ResourceNotFoundException;
import com.groupeonepoint.abrahime.eshopping.models.Order;
import com.groupeonepoint.abrahime.eshopping.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
   public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
   public Order updateOrder(Order order){
        Optional<Order> orderDb= this.orderRepository.findById(order.getOrderId());
        if(orderDb.isPresent()){
            Order orderUpdate= orderDb.get();
            orderUpdate.setOrderId(order.getOrderId());
            orderUpdate.setOrderStatus(order.getOrderStatus());
            orderUpdate.setShipmentAmount(order.getShipmentAmount());
            orderRepository.save(orderUpdate);
            return orderUpdate;
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+order.getOrderId());
        }

    }

    @Override
    public List<Order> getAllOrder(){
        return this.orderRepository.findAll();

    }

    @Override
    public Order getOrderById(long orderId){
        Optional<Order> orderDb= this.orderRepository.findById(orderId);
        if(orderDb.isPresent()){
            return orderDb.get();
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+orderId);
        }
    }

    @Override
    public void deleteOrder(long orderId){
        Optional<Order> orderDb= this.orderRepository.findById(orderId);
        if(orderDb.isPresent()){
            this.orderRepository.delete(orderDb.get());
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+orderId);
        }
    }
}
