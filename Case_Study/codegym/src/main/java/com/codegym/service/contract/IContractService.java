package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IContractService extends IGeneralService<Contract> {
    Optional<Contract> findById(Integer id);

    void remove(Integer id);
}
