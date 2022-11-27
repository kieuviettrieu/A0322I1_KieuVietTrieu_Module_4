package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;
import com.codegym.cms.model.BlogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogTypeRepository extends JpaRepository<BlogType,Long> {
    @Query(value = "from BlogType where tenBlogType like :keyword")
    List<BlogType> searchName(@Param("keyword") String name);

    Page<BlogType> findAllByTenBlogTypeContaining(String name, Pageable pageable);

    Page<BlogType> findAll(Pageable pageable);
}
