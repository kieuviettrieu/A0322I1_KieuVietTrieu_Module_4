package com.codegym.model.person;

import com.codegym.model.CustomerType;
import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customer_Id;
    private String customer_Name;
    private Date customer_Birthday;
    private boolean customer_Gender;
    private String customer_Id_Card;
    private String customer_Phone;
    private String customer_Email;
    @ManyToOne
    @JoinColumn(name = "customer_Id", referencedColumnName = "customer_Type_Id")
    private CustomerType customerType;
    private String customer_Address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    public Customer() {
    }

    public Customer(String customer_Id, String customer_Name, Date customer_Birthday, boolean customer_Gender,
                    String customer_Id_Card, String customer_Phone, String customer_Email, CustomerType customerType,
                    String customer_Address) {
        this.customer_Id = customer_Id;
        this.customer_Name = customer_Name;
        this.customer_Birthday = customer_Birthday;
        this.customer_Gender = customer_Gender;
        this.customer_Id_Card = customer_Id_Card;
        this.customer_Phone = customer_Phone;
        this.customer_Email = customer_Email;
        this.customerType = customerType;
        this.customer_Address = customer_Address;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public Date getCustomer_Birthday() {
        return customer_Birthday;
    }

    public void setCustomer_Birthday(Date customer_Birthday) {
        this.customer_Birthday = customer_Birthday;
    }

    public boolean isCustomer_Gender() {
        return customer_Gender;
    }

    public void setCustomer_Gender(boolean customer_Gender) {
        this.customer_Gender = customer_Gender;
    }

    public String getCustomer_Id_Card() {
        return customer_Id_Card;
    }

    public void setCustomer_Id_Card(String customer_Id_Card) {
        this.customer_Id_Card = customer_Id_Card;
    }

    public String getCustomer_Phone() {
        return customer_Phone;
    }

    public void setCustomer_Phone(String customer_Phone) {
        this.customer_Phone = customer_Phone;
    }

    public String getCustomer_Email() {
        return customer_Email;
    }

    public void setCustomer_Email(String customer_Email) {
        this.customer_Email = customer_Email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}