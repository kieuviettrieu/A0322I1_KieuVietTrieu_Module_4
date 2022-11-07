package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String describes;

    public Product() {
    }

    public Product(String name, double price, int quantity, String describe) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describes = describe;
    }

    public Product(Long id, String name, double price, int quantity, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describes = describe;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describe) {
        this.describes = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", describe='" + describes + '\'' +
                '}';
    }
}
