package com.codegym.cms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t) throws Exception;

    void remove(Long id);

    Page<T> findAll(Pageable pageable);

    Page<T> listSearchByName(String keywordVal, Pageable pageable);
}