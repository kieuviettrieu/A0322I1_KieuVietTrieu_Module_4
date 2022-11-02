package com.example.quan_ly_sanpham.model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String describe;

    public Product() {
    }

    public Product(int id, String name, int quantity, String describe) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
