package com.groupeonepoint.abrahime.eshopping.util.enumeration;

public enum OrderStatus {
    PENDING("Pending"), PAID("Paid"), CANCELLED("Cancelled");
    private String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
