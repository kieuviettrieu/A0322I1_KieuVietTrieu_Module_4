package com.codegym.service.facitily;

import com.codegym.model.facitily.Service;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IServiceService extends IGeneralService<Service> {

    Optional<Service> findById(String id);

    void remove(String id);
}
