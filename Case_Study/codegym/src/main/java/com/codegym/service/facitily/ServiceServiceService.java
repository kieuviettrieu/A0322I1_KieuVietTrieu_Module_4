package com.codegym.service.facitily;

import com.codegym.model.facitily.Service;
import com.codegym.repository.facitily.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }


    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Optional<Service> findById(String id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }
}
