package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class SellDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sellDetailId;
    private int amount;
    private int buyPrice;

    @OneToOne
    private Goods goods;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "sellId")
    @JsonBackReference
    private Sell sell;

    public SellDetail() {
    }

    public SellDetail(long sellDetailId, int amount, int buyPrice, Goods goods, Sell sell) {
        this.sellDetailId = sellDetailId;
        this.amount = amount;
        this.buyPrice = buyPrice;
        this.goods = goods;
        this.sell = sell;
    }

    public long getSellDetailId() {
        return sellDetailId;
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

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }
}
