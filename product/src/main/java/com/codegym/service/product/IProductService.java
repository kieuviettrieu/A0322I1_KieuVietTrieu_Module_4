package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllByFirstLastDay(Date firstDay, Date lastDay, Pageable pageable);
}
