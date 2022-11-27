package com.codegym.cms.service.imp;

import com.codegym.cms.model.BlogType;
import com.codegym.cms.repository.IBlogTypeRepository;
import com.codegym.cms.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService {
    @Autowired
    IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> findAll() {
        return blogTypeRepository.findAll();
    }

    @Override
    public BlogType findById(Long id) {
        return blogTypeRepository.findById(id).get();
    }

    @Override
    public void save(BlogType blogType) {
        blogTypeRepository.save(blogType);
    }

    @Override
    public void remove(Long id) {
        blogTypeRepository.deleteById(id);
    }

    @Override
    public Iterable<BlogType> findAll(String name) {
        String nameQuery='%'+name+'%';
        return blogTypeRepository.searchName(nameQuery);
    }

    @Override
    public Page<BlogType> findAll(Pageable pageable) {
        return blogTypeRepository.findAll(pageable);
    }

    @Override
    public Page<BlogType> listSearchByName(String keywordVal, Pageable pageable) {
        return blogTypeRepository.findAllByTenBlogTypeContaining(keywordVal, pageable);
    }
}
