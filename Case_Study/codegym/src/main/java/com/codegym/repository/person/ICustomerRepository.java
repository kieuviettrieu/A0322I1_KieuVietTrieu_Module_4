package com.codegym.repository.person;

import com.codegym.model.person.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,String> {
}
