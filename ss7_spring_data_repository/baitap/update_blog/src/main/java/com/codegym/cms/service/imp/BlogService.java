package com.codegym.cms.service.imp;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.IBlogRepository;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAll(String name) {
        String nameQuery='%'+name+'%';
        return blogRepository.searchName(nameQuery);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listSearchByName(String keywordVal, Pageable pageable) {
        return blogRepository.findAllByTenBlogContaining(keywordVal,pageable);
    }
}
