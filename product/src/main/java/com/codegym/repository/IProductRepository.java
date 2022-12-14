package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Page<Product> findAll(Pageable pageable);

    @Query("SELECT e FROM Product e WHERE (Date(e.firstDay) between date(?1) and date(?2)) or (Date(e.lastDay) between date(?1) and date(?2)) or " +
            "(date(?1) between date(e.firstDay) and date(e.lastDay)) or (date(?2) between date(e.firstDay) and date(e.lastDay))")
    Page<Product> findAllByFirstLastDay(Date firstDay, Date lastDay, Pageable pageable);
}
