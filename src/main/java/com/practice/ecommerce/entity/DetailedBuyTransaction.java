package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class DetailedBuyTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long detailedBuyId;
    private int amount;
    private int buyPrice;

    @OneToOne(fetch = FetchType.LAZY)
    private Goods goods;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "buyId")
//    @JsonManagedReference
    @JsonBackReference
    private BuyTransaction buyTransaction;

    public DetailedBuyTransaction() {
    }

    public DetailedBuyTransaction(long detailedBuyId, int amount, int buyPrice, Goods goods, BuyTransaction buyTransaction) {
        this.detailedBuyId = detailedBuyId;
        this.amount = amount;
        this.buyPrice = buyPrice;
        this.goods = goods;
        this.buyTransaction = buyTransaction;
    }

    public long getDetailedBuyId() {
        return detailedBuyId;
    }

    public void setDetailedBuyId(long detailedBuyId) {
        this.detailedBuyId = detailedBuyId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BuyTransaction getBuyTransaction() {
        return buyTransaction;
    }

    public void setBuyTransaction(BuyTransaction buyTransaction) {
        this.buyTransaction = buyTransaction;
    }
}
