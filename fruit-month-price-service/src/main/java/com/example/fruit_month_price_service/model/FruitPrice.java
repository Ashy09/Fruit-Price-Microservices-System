package com.example.fruit_month_price_service.model;

import jakarta.persistence.*;

@Entity
public class FruitPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fruit;

    @Column(name = "`month`")
    private String month;

    private Double price;

    public FruitPrice() {}

    public FruitPrice(Long id, String fruit, String month, Double price) {
        this.id = id;
        this.fruit = fruit;
        this.month = month;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFruit() { return fruit; }
    public void setFruit(String fruit) { this.fruit = fruit; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}