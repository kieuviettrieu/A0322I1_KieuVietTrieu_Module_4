package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderRepository extends JpaRepository<Oder,Long> {
    Page<Oder> findAll(Pageable pageable);
}
