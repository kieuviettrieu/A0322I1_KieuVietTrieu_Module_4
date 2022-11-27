package com.codegym.cms.service;

import com.codegym.cms.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService extends IGeneralService<Blog> {
    Optional<Blog> findByIdOp(Long id);

    Iterable<Blog> findAllByNameBlog(String name);
}
