package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);

    List<T> findAll(String name);

    Page<T> findAll(Pageable pageable);

    Page<T> listSearchByName(String keywordVal, Pageable pageable);
}