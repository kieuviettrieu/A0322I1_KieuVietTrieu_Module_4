package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Long id);

    void delete(Long id);

    Page<T> findAll(Pageable pageable);
}
