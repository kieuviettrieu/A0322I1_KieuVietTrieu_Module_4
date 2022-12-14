package com.codegym.model;

import com.codegym.model.person.Customer;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customer_Type_Name;

    @OneToMany(mappedBy = "customerType",cascade = CascadeType.REMOVE)
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(int id, String customer_Type_Name) {
        this.id = id;
        this.customer_Type_Name = customer_Type_Name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int customer_Type_Id) {
        this.id = customer_Type_Id;
    }

    public String getCustomer_Type_Name() {
        return customer_Type_Name;
    }

    public void setCustomer_Type_Name(String customer_Type_Name) {
        this.customer_Type_Name = customer_Type_Name;
    }

}
