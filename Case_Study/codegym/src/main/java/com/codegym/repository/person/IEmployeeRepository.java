package com.codegym.repository.person;

import com.codegym.model.person.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
}
