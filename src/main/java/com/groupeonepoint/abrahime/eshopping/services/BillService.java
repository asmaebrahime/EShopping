package com.groupeonepoint.abrahime.eshopping.services;

import com.groupeonepoint.abrahime.eshopping.models.Bill;

import java.util.List;

public interface BillService {
    Bill createBill(Bill bill);
    Bill updateBill(Bill bill);
    List<Bill> getAllBill();
    Bill getBillById(long orderId);
    void deleteBill(long orderId);
    List<Bill> getAllBillSortedByCreationDate();
}
