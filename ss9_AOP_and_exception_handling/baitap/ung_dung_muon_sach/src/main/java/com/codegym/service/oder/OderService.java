package com.codegym.service.oder;

import com.codegym.model.Oder;
import com.codegym.repository.IOderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService{

    @Autowired
    IOderRepository oderRepository;

    @Override
    public List<Oder> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public Oder findById(Long id) {
        return oderRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        oderRepository.deleteById(id);
    }

    @Override
    public Page<Oder> findAll(Pageable pageable) {
        return oderRepository.findAll(pageable);
    }
}
