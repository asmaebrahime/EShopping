package com.groupeonepoint.abrahime.eshopping.models;

import com.groupeonepoint.abrahime.eshopping.util.enumeration.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
public  class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private BigDecimal shipmentAmount;

    @Transient
    private BigDecimal totalAmount;

    @OneToMany(targetEntity = OrderLine.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderLine> orderLineList;

    public Order( OrderStatus orderStatus, BigDecimal shipmentAmount, List<OrderLine> orderLineList, BigDecimal totalAmount) {
        this.orderStatus = orderStatus;
        this.shipmentAmount = shipmentAmount;
        this.orderLineList = orderLineList;
        this.totalAmount = totalAmount;
    }

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getShipmentAmount() {
        return shipmentAmount;
    }

    public void setShipmentAmount(BigDecimal shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLine(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

   /* public void calculateOrderTotalAmount(){
        Double amount = this.orderLineList.stream().mapToDouble(x -> x.getPrice()*x.getQuantity()).sum();
        setOrderTotalPrice(price);
    }*/
}
