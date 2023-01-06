package com.practice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Buy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int date;
    private int time;
    private int sumOfPrice;

    @OneToMany(mappedBy = "buy", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BuyDetail> buyDetails;

    public Buy() {
    }

    public Buy(long id, int date, int time, int sumOfPrice, List<BuyDetail> buyDetails) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.sumOfPrice = sumOfPrice;
        this.buyDetails = buyDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long buyId) {
        this.id = buyId;
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

    public List<BuyDetail> getBuyDetails() {
        return buyDetails;
    }

    public void setBuyDetails(List<BuyDetail> buyDetails) {
        this.buyDetails = buyDetails;
    }
}
