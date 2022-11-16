package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nameBook;

    @Min(0)
    private int quantity;

    @NotBlank
    private String author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.REMOVE)
    private Set<Oder> oderSet;

    public Book() {
    }

    public Book(Long id, String nameBook, int quantity, String author) {
        this.id = id;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", quantity=" + quantity +
                ", author='" + author + '\'' +
                '}';
    }
}
