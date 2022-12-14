package com.codegym.service.impl;

import com.codegym.model.Hotel;
import com.codegym.repository.IHotelRepository;
import com.codegym.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements IHotelService {
    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        hotelRepository.findById(id);
    }
}
