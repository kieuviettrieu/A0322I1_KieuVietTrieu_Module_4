package com.codegym.repository;

import com.codegym.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query("SELECT e FROM Contract e WHERE e.customer.name=?1")
    List<Contract> findAllByNameCustomer(String name);


    List<Contract> findAllByContractTypeContaining(String contractType);

    @Query("SELECT e FROM Contract e WHERE e.contractType=?1 and e.customer.name=?2")
    List<Contract> findAllBy(String contractType,String name);
}
