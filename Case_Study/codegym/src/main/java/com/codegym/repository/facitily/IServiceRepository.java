package com.codegym.repository.facitily;

import com.codegym.model.facitily.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,String> {
}
