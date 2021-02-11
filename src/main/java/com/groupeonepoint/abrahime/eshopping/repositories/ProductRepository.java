package com.groupeonepoint.abrahime.eshopping.repositories;

import com.groupeonepoint.abrahime.eshopping.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {



}
