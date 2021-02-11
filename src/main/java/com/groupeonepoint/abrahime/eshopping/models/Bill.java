package com.groupeonepoint.abrahime.eshopping.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long billId;

    @Column(name="creationDate")
    private Date creationDate;
    @Column(name="amount")
    private BigDecimal amount;

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
