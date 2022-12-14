package com.codegym.repository.person;

import com.codegym.model.person.Customer;
import com.codegym.model.person.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);

    Page<Employee> findAll(Pageable pageable);
}
