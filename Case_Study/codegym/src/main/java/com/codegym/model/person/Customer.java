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
    private Integer id;
    private String name;
    private Date birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    @ManyToOne
    @JoinColumn
    private CustomerType customerType;
    private String address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    public Customer() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String customer_Name) {
        this.name = customer_Name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date customer_Birthday) {
        this.birthday = customer_Birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String customer_Gender) {
        this.gender = customer_Gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String customer_Id_Card) {
        this.idCard = customer_Id_Card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String customer_Phone) {
        this.phone = customer_Phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String customer_Email) {
        this.email = customer_Email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String customer_Address) {
        this.address = customer_Address;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}