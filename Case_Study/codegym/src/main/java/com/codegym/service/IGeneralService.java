package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    void save(T t);

}