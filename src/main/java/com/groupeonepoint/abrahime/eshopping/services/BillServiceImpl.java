package com.groupeonepoint.abrahime.eshopping.services;

import com.groupeonepoint.abrahime.eshopping.exceptions.ResourceNotFoundException;
import com.groupeonepoint.abrahime.eshopping.models.Bill;

import com.groupeonepoint.abrahime.eshopping.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    public Bill createBill(Bill bill){
        return billRepository.save(bill);
    }
    public Bill updateBill(Bill bill){
        Optional<Bill> billDb= this.billRepository.findById(bill.getBillId());
        if(billDb.isPresent()){
            Bill billUpdate= billDb.get();
            billUpdate.setBillId(bill.getBillId());
            billUpdate.setCreationDate(bill.getCreationDate());
            billUpdate.setAmount(bill.getAmount());
            billRepository.save(billUpdate);
            return billUpdate;
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+bill.getBillId());
        }

    }
    public List<Bill> getAllBill(){
        return this.billRepository.findAll();
    }
    public Bill getBillById(long billId){
        Optional<Bill> billDb= this.billRepository.findById(billId);
        if(billDb.isPresent()){
            return billDb.get();
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+billId);
        }

    }
    public void deleteBill(long billId){
        Optional<Bill> billDb= this.billRepository.findById(billId);
        if(billDb.isPresent()){
            this.billRepository.delete(billDb.get());
        }
        else {
            throw new ResourceNotFoundException("Record not found with id: "+billId);
        }

    }
    public List<Bill> getAllBillSortedByCreationDate(){
        Sort sortCreationDate = Sort.by("creationDate");
        return this.billRepository.findAll(sortCreationDate);

    }
}
