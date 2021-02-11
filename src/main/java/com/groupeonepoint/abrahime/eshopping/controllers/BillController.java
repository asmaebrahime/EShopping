package com.groupeonepoint.abrahime.eshopping.controllers;

import com.groupeonepoint.abrahime.eshopping.models.Bill;
import com.groupeonepoint.abrahime.eshopping.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> getAllBill(){
        return ResponseEntity.ok().body(billService.getAllBill());
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable long id){
        return ResponseEntity.ok().body(billService.getBillById(id));
    }
    @PostMapping("/bills")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        return ResponseEntity.ok().body(this.billService.createBill(bill));

    }

    @PutMapping("/bills/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable long id, @RequestBody Bill bill){
        bill.setBillId(id);
        return ResponseEntity.ok().body(this.billService.updateBill(bill));
    }

    @DeleteMapping("/bills/{id}")
    public HttpStatus deleteOrder(@PathVariable long id){
        this.billService.deleteBill(id);
        //return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
        return HttpStatus.OK;
    }

    @GetMapping("/bills?sort=creationDate")
    public ResponseEntity<List<Bill>> getAllBillSortedByCreationDate(){
        return ResponseEntity.ok().body(billService.getAllBillSortedByCreationDate());
    }


}
