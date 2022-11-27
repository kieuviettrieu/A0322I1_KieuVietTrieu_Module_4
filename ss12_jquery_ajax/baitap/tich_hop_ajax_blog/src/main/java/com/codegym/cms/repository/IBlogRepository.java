package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {

    @Query(value = "from Blog where tenBlog like :keyword")
    List<Blog> searchName(@Param("keyword") String name);

    Page<Blog> findAllByTenBlogContaining(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Iterable<Blog> findAllByTenBlogContaining(String name);
}
