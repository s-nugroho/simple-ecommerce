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
    private int price;

    @OneToOne
    private Goods good;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Sell sell;

    public SellDetail() {
    }

    public SellDetail(long sellDetailId, int amount, int price, Goods good, Sell sell) {
        this.sellDetailId = sellDetailId;
        this.amount = amount;
        this.price = price;
        this.good = good;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int buyPrice) {
        this.price = buyPrice;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods goods) {
        this.good = goods;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }
}
