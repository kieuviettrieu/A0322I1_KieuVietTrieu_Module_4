package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "productpay")
public class ProductPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private double price;
    private int quantity;
    private String description;

    public ProductPay() {
    }

    public ProductPay(String name, String image, double price, int quantity, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public ProductPay(Long id, String name, String image, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
