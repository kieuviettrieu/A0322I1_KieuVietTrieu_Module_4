package com.codegym.service;

import com.codegym.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {
    List<Hotel> findAll();

    void save(Hotel hotel);

    Optional<Hotel> findById(Integer id);

    void remove(Integer id);
}
