package com.groupeonepoint.abrahime.eshopping.repositories;

import com.groupeonepoint.abrahime.eshopping.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillRepository extends JpaRepository<Bill, Long>, PagingAndSortingRepository<Bill, Long> {

}
