package com.codegym.repository.facitily;

import com.codegym.model.facitily.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {
}
