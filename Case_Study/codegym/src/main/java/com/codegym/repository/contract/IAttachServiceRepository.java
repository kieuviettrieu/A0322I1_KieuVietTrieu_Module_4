package com.codegym.repository.contract;

import com.codegym.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService,Integer> {
}
