package com.codegym.service.impl;

import com.codegym.model.Contract;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllByName(String keywordVal, Pageable pageable) {
        return contractRepository.findAllByNameContaining(keywordVal, pageable);
    }

    @Override
    public Page<Contract> findAllByFirstLastDay(Date firstDay, Date lastDay,Pageable pageable) {
        return contractRepository.findAllByFirstLastDay(firstDay, lastDay,pageable);
    }
}
