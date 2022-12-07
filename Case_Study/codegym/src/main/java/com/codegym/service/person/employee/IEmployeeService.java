package com.codegym.service.person.employee;

import com.codegym.model.contract.Contract;
import com.codegym.model.person.Employee;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IEmployeeService extends IGeneralService<Employee> {
    Optional<Employee> findById(String id);

    void remove(String id);
}
