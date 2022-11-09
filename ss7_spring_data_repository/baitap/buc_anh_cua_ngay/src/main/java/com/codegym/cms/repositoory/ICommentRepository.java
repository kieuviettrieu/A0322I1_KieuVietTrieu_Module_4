package com.codegym.cms.repositoory;

import com.codegym.cms.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "from Comment where author like :keyword")
    List<Comment> searchName(@Param("keyword") String name);

    Page<Comment> findAllByAuthorContaining(String name, Pageable pageable);

    Page<Comment> findAll(Pageable pageable);
}
