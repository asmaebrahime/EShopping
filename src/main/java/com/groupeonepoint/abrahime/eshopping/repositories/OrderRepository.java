package com.groupeonepoint.abrahime.eshopping.repositories;

import com.groupeonepoint.abrahime.eshopping.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
