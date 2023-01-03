package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class BuyDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long buyDetailId;
    private int amount;
    private int buyPrice;

    @OneToOne
    private Goods goods;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "buyId")
    @JsonBackReference
    private Buy buy;

    public BuyDetail() {
    }

    public BuyDetail(long buyDetailId, int amount, int buyPrice, Goods goods, Buy buy) {
        this.buyDetailId = buyDetailId;
        this.amount = amount;
        this.buyPrice = buyPrice;
        this.goods = goods;
        this.buy = buy;
    }

    public long getBuyDetailId() {
        return buyDetailId;
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

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }
}
