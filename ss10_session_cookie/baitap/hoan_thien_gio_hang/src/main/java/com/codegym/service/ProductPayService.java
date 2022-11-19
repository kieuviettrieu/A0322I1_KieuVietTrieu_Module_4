package com.codegym.service;

import com.codegym.model.ProductPay;
import com.codegym.repository.IProductPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPayService implements IProductPayService{
    @Autowired
    IProductPayRepository payRepository;

    @Override
    public List<ProductPay> findAll() {
        return payRepository.findAll();
    }

    @Override
    public ProductPay findById(Long id) {
        return payRepository.findById(id).get();
    }

    @Override
    public void save(ProductPay productPay) {
        payRepository.save(productPay);
    }

    @Override
    public void remove(Long id) {
        payRepository.deleteById(id);
    }

    @Override
    public Page<ProductPay> findAll(Pageable pageable) {
        return payRepository.findAll(pageable);
    }

    @Override
    public void saveList(List<ProductPay> list) {
        payRepository.saveAll(list);
    }
}
