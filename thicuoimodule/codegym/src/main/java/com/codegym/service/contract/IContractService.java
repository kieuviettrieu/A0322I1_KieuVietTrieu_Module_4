package com.codegym.service.contract;

import com.codegym.model.Contract;
import com.codegym.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IContractService extends IGeneralService<Contract> {


    List<Contract> findAllByName(String name);

    List<Contract> findAllByContractType(String contractType);

    List<Contract> findAll(String contractType,String name);
}
