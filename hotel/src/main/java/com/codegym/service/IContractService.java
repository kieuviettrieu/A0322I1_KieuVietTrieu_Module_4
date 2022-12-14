package com.codegym.service;

import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;


public interface IContractService extends IGeneralService<Contract> {
    Page<Contract> findAllByFirstLastDay(Date firstDay, Date lastDay, Pageable pageable);
}
