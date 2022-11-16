package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idBook", referencedColumnName = "id")
    private Book book;

    @Min(0)
    private int quantity;

    public Oder() {
    }

    public Oder(Long id, Book book, int quantity) {
        this.id = id;
        this.book = book;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "id=" + id +
                ", book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}

