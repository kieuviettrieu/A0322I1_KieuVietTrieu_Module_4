package com.codegym.model;

import com.codegym.model.person.Customer;
import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_Type_Id;

    private String customer_Type_Name;

    @OneToMany(mappedBy = "customerType",cascade = CascadeType.REMOVE)
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(int customer_Type_Id, String customer_Type_Name) {
        this.customer_Type_Id = customer_Type_Id;
        this.customer_Type_Name = customer_Type_Name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public int getCustomer_Type_Id() {
        return customer_Type_Id;
    }

    public void setCustomer_Type_Id(int customer_Type_Id) {
        this.customer_Type_Id = customer_Type_Id;
    }

    public String getCustomer_Type_Name() {
        return customer_Type_Name;
    }

    public void setCustomer_Type_Name(String customer_Type_Name) {
        this.customer_Type_Name = customer_Type_Name;
    }

}
