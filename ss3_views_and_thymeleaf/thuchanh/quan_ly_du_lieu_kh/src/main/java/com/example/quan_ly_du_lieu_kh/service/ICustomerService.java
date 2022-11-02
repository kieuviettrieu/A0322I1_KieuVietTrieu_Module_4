package com.example.quan_ly_du_lieu_kh.service;


import com.example.quan_ly_du_lieu_kh.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
