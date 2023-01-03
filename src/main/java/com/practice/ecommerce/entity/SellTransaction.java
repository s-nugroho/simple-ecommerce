package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class SellTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sellId;
    private int date;
    private int time;
    private int sumOfPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sellTransaction", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<DetailedSellTransaction> detailedSellTransactions;

    public SellTransaction() {
    }

    public SellTransaction(long sellId, int date, int time, int sumOfPrice, List<DetailedSellTransaction> detailedSellTransactions) {
        this.sellId = sellId;
        this.date = date;
        this.time = time;
        this.sumOfPrice = sumOfPrice;
        this.detailedSellTransactions = detailedSellTransactions;
    }

    public long getSellId() {
        return sellId;
    }

    public void setSellId(long sellId) {
        this.sellId = sellId;
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

    public List<DetailedSellTransaction> getDetailedSellTransactions() {
        return detailedSellTransactions;
    }

    public void setDetailedSellTransactions(List<DetailedSellTransaction> detailedSellTransactions) {
        this.detailedSellTransactions = detailedSellTransactions;
    }
}
