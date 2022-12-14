package com.codegym.service.person.customer;

import com.codegym.model.contract.Contract;
import com.codegym.model.person.Customer;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Optional<Customer> findById(Integer id);

    void remove(Integer id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> listSearchByName(String keywordVal, Pageable pageable);
}
