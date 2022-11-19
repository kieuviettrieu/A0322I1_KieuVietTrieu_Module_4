package com.codegym.service;

import com.codegym.model.ProductPay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductPayService {
    List<ProductPay> findAll();

    ProductPay findById(Long id);

    void save(ProductPay productPay);

    void remove(Long id);

//    List<ProductPay> findAll(String name);

    Page<ProductPay> findAll(Pageable pageable);

    void saveList(List<ProductPay> list);

//    Page<ProductPay> listSearchByName(String keywordVal, Pageable pageable);
}
