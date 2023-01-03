package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class BuyTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long buyId;
    private int date;
    private int time;
    private int sumOfPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buyTransaction", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetailedBuyTransaction> detailedBuyTransactions;

    public BuyTransaction() {
    }

    public BuyTransaction(long buyId, int date, int time, int sumOfPrice, List<DetailedBuyTransaction> detailedBuyTransactions) {
        this.buyId = buyId;
        this.date = date;
        this.time = time;
        this.sumOfPrice = sumOfPrice;
        this.detailedBuyTransactions = detailedBuyTransactions;
    }

    public long getBuyId() {
        return buyId;
    }

    public void setBuyId(long buyId) {
        this.buyId = buyId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSumOfPrice() {
        return sumOfPrice;
    }

    public void setSumOfPrice(int sumOfPrice) {
        this.sumOfPrice = sumOfPrice;
    }

    public List<DetailedBuyTransaction> getDetailedBuyTransaction() {
        return detailedBuyTransactions;
    }

    public void setDetailedBuyTransaction(List<DetailedBuyTransaction> detailedBuyTransactions) {
        this.detailedBuyTransactions = detailedBuyTransactions;
    }
}
