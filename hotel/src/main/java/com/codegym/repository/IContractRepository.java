package com.codegym.repository;

import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAllByNameContaining(String name, Pageable pageable);

    Page<Contract> findAll(Pageable pageable);

    @Query("SELECT e FROM Contract e WHERE (Date(e.firtsDay) between date(?1) and date(?2)) or (Date(e.lastDay) between date(?1) and date(?2))")
    Page<Contract> findAllByFirstLastDay(Date firstDay, Date lastDay,Pageable pageable);
}
