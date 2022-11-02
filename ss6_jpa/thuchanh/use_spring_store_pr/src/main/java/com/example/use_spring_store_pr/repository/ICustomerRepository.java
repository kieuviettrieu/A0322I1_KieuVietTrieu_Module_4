package com.example.use_spring_store_pr.repository;

import com.example.use_spring_store_pr.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}