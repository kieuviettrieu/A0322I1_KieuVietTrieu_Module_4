package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    void save(T t);

    Optional<T> findById(Integer id);

    void remove(Integer id);

    Page<T> findAll(Pageable pageable);

    Page<T> findAllByName(String keywordVal, Pageable pageable);
}