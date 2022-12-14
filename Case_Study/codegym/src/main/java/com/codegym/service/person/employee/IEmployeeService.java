package com.codegym.service.person.employee;

import com.codegym.model.contract.Contract;
import com.codegym.model.person.Employee;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService extends IGeneralService<Employee> {
    Optional<Employee> findById(Integer id);

    void remove(Integer id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> listSearchByName(String keywordVal, Pageable pageable);
}
