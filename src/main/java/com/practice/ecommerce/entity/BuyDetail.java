package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class BuyDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amount;
    private int price;

    @OneToOne
    private Goods good;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Buy buy;

    public BuyDetail() {
    }

    public BuyDetail(long id, int amount, int price, Goods good, Buy buy) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.good = good;
        this.buy = buy;
    }

    public long getId() {
        return id;
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

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }
}
