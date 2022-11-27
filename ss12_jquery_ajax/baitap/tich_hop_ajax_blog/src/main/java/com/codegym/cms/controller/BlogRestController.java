package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.model.BlogType;
import com.codegym.cms.service.IBlogService;
import com.codegym.cms.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    @Autowired
    IBlogTypeService blogTypeService;

    @GetMapping("/blogs")
    public ModelAndView list()
    {
        ModelAndView modelAndView=new ModelAndView("blog/list");
        String nameSearch="";
        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }

//    @GetMapping("/blogs")
//    public ResponseEntity<List<Blog>> list()
//    {
//        List<Blog> blogs=blogService.findAll();
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }

    @GetMapping("/blog-types")
    public ResponseEntity<List<BlogType>> listType()
    {
        List<BlogType> blogTypes=blogTypeService.findAll();
        return new ResponseEntity<>(blogTypes, HttpStatus.OK);
    }

    @GetMapping("/detail-blog/{id}")
    public ResponseEntity<Blog> detailBlog(@PathVariable Long id)
    {
        Blog blog=blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @DeleteMapping("/delete-blog/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id)
    {
        Optional<Blog> blog = blogService.findByIdOp(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/search-name-blog")
    public ResponseEntity<Iterable<Blog>> listBlog(@RequestBody String searchValue){
        return new ResponseEntity<>(blogService.findAllByNameBlog(searchValue),HttpStatus.OK);
    }
}
