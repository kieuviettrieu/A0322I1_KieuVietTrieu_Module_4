package com.example.cms.controller;

import com.example.cms.model.Comment;
import com.example.cms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/comments")
    public ModelAndView listComments() {
        List<Comment> comments = commentService.findAll();
        List<Integer> points=new ArrayList<>();
        points.add(1);
        points.add(2);
        points.add(3);
        points.add(4);
        points.add(5);

        ModelAndView modelAndView = new ModelAndView("/comment/list");
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("points",points);
        return modelAndView;
    }

    @GetMapping("/comment-detail/{id}")
    public ModelAndView commentsDetail(@PathVariable Long id) {
        Comment comment=commentService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/comment/detail");
        modelAndView.addObject("comment",comment);
        return modelAndView;
    }

    @PostMapping("/comment-create")
    public String saveComment(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        return "redirect:comments";
    }

//    @PostMapping("/comment-update")
//    public String update(@ModelAttribute("comment") Comment comment) {
//        commentService.save(comment);
//        return "redirect:comments";
//    }

//    @GetMapping("/comment-detail/{id}")
//    public ModelAndView showDetailForm(@PathVariable Long id) {
//        Comment comment = commentService.findById(id);
//        if (comment != null) {
//            ModelAndView modelAndView = new ModelAndView("/comment/detail");
//            modelAndView.addObject("comment", comment);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }

    @GetMapping("/comment-like/{id}")
    public ModelAndView like(@PathVariable Long id)
    {
        Comment comment=commentService.findById(id);
        int like=comment.getLikeComment();
        comment.setLikeComment(++like);
        commentService.save(comment);

        List<Comment> comments = commentService.findAll();
        List<Integer> points=new ArrayList<>();
        points.add(1);
        points.add(2);
        points.add(3);
        points.add(4);
        points.add(5);

        ModelAndView modelAndView = new ModelAndView("/comment/list");

        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("points",points);
        return modelAndView;
    }
}

