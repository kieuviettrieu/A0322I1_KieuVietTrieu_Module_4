package com.example.use_spring_store_pr.service;

import com.example.use_spring_store_pr.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}