//package com.codegym.cms.controller;
//
//import com.codegym.cms.model.Blog;
//import com.codegym.cms.model.BlogType;
//import com.codegym.cms.service.IBlogService;
//import com.codegym.cms.service.IBlogTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class BlogController {
//
//    @Autowired
//    IBlogService blogService;
//
//    @Autowired
//    IBlogTypeService blogTypeService;
//
//    @GetMapping("/blogs")
//    public ModelAndView list()
//    {
//        ModelAndView modelAndView=new ModelAndView("blog/list");
//        String nameSearch="";
//        modelAndView.addObject("nameSearch",nameSearch);
//        modelAndView.addObject("blogs",blogService.findAll());
//        return modelAndView;
//    }
//
//    @GetMapping("/blog-types")
//    public ModelAndView listBlogType(@PageableDefault(value = 5) Pageable pageable)
//    {
//        ModelAndView modelAndView=new ModelAndView("blogtype/list");
//        modelAndView.addObject("blogTypes",blogTypeService.findAll(pageable));
//        return modelAndView;
//    }
//
////    @PostMapping("/blogs-search-name")
////    public ModelAndView listSearchBlogName(@ModelAttribute("nameSearch") String nameSearch, @PageableDefault(value = 5) Pageable pageable)
////    {
////        ModelAndView modelAndView=new ModelAndView("blog/list");
////        modelAndView.addObject("nameSearch",nameSearch);
////        modelAndView.addObject("blogs",blogService.listSearchByName(nameSearch, pageable));
////        return modelAndView;
////    }
//
//    @PostMapping("/blog-types-search-name")
//    public ModelAndView listSearchBlogTypeName(@ModelAttribute("nameSearch") String nameSearch, @PageableDefault(value = 5) Pageable pageable)
//    {
//        ModelAndView modelAndView=new ModelAndView("blogtype/list");
//        modelAndView.addObject("blogTypes",blogTypeService.listSearchByName(nameSearch,pageable));
//        return modelAndView;
//    }
//
//
//
//    @GetMapping("/create-blog")
//    public ModelAndView showCreateBlog() {
//        ModelAndView modelAndView = new ModelAndView("blog/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("blogTypes",blogTypeService.findAll());
//        return modelAndView;
//    }
//
//    @GetMapping("/create-blog-type")
//    public ModelAndView showCreateBlogType() {
//        ModelAndView modelAndView = new ModelAndView("blogtype/create");
//        modelAndView.addObject("blogType", new BlogType());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-blog")
//    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("blog/create");
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("blogTypes",blogTypeService.findAll());
//        modelAndView.addObject("message", "New blog created successfully");
//        return modelAndView;
//    }
//
//    @PostMapping("/create-blog-type")
//    public ModelAndView saveBlogType(@ModelAttribute("blogType") BlogType blogType) {
//        blogTypeService.save(blogType);
//        ModelAndView modelAndView = new ModelAndView("blogtype/create");
//        modelAndView.addObject("blogType", new BlogType());
//        modelAndView.addObject("message", "New blog type created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit-blog/{id}")
//    public ModelAndView showEditBlog(@PathVariable Long id) {
//        Blog blog=blogService.findById(id);
//        if (blog!=null) {
//            ModelAndView modelAndView = new ModelAndView("blog/edit");
//            modelAndView.addObject("blog", blog);
//            modelAndView.addObject("blogTypes",blogTypeService.findAll());
//            return modelAndView;
//        } else {
//            return new ModelAndView("error.404");
//        }
//    }
//
//    @GetMapping("/edit-blog-type/{id}")
//    public ModelAndView showEditBlogType(@PathVariable Long id) {
//        BlogType blogType=blogTypeService.findById(id);
//        if (blogType!=null) {
//            ModelAndView modelAndView = new ModelAndView("blogtype/edit");
//            modelAndView.addObject("blogType", blogType);
//            return modelAndView;
//        } else {
//            return new ModelAndView("error.404");
//        }
//    }
//
//    @PostMapping("/edit-blog")
//    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("blog/edit");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("blogTypes",blogTypeService.findAll());
//        modelAndView.addObject("message", "Blog updated successfully");
//        return modelAndView;
//    }
//
//    @PostMapping("/edit-blog-type")
//    public ModelAndView updateBlogType(@ModelAttribute("blogType") BlogType blogType) {
//        blogTypeService.save(blogType);
//        ModelAndView modelAndView = new ModelAndView("blogtype/edit");
//        modelAndView.addObject("blogType", blogType);
//        modelAndView.addObject("message", "Blog type updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-blog/{id}")
//    public ModelAndView showDeleteBlog(@PathVariable Long id) {
//        Blog blog=blogService.findById(id);
//        if (blog!=null) {
//            ModelAndView modelAndView = new ModelAndView("blog/delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error.404");
//        }
//    }
//
//    @GetMapping("/delete-blog-type/{id}")
//    public ModelAndView showDeleteBlogType(@PathVariable Long id) {
//        BlogType blogType=blogTypeService.findById(id);
//        if (blogType!=null) {
//            ModelAndView modelAndView = new ModelAndView("blogtype/delete");
//            modelAndView.addObject("blogType", blogType);
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error.404");
//        }
//    }
//
//    @PostMapping("/delete-blog")
//    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.remove(blog.getId());
//        return "redirect:blogs";
//    }
//
//    @PostMapping("/delete-blog-type")
//    public String deleteBlogType(@ModelAttribute("blogType") BlogType blogType) {
//        blogTypeService.remove(blogType.getId());
//        return "redirect:blog-types";
//    }
//
//
//    @GetMapping("/detail-blog/{id}")
//    public ModelAndView showDetailBlog(@PathVariable Long id) {
//        Blog blog=blogService.findById(id);
//        if (blog!=null) {
//            ModelAndView modelAndView = new ModelAndView("blog/detail");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error.404");
//        }
//    }
//}
