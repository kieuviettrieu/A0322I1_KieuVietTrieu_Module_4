package com.codegym.service.person.customer;

import com.codegym.model.contract.Contract;
import com.codegym.model.person.Customer;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Optional<Customer> findById(String id);

    void remove(String id);
}
