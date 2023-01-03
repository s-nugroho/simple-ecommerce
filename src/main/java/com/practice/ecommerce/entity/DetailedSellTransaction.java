package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class DetailedSellTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long detailedSellId;
    private int amount;
    private int buyPrice;

    @OneToOne(fetch = FetchType.LAZY)
    private Goods goods;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "sellId")
    @JsonBackReference
    private SellTransaction sellTransaction;

    public DetailedSellTransaction() {
    }

    public DetailedSellTransaction(long detailedSellId, int amount, int buyPrice, Goods goods, SellTransaction sellTransaction) {
        this.detailedSellId = detailedSellId;
        this.amount = amount;
        this.buyPrice = buyPrice;
        this.goods = goods;
        this.sellTransaction = sellTransaction;
    }

    public long getDetailedSellId() {
        return detailedSellId;
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

    public SellTransaction getSellTransaction() {
        return sellTransaction;
    }

    public void setSellTransaction(SellTransaction sellTransaction) {
        this.sellTransaction = sellTransaction;
    }
}
