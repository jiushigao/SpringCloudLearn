package com.example.springcloudsecurity.controller;

import com.example.springcloudsecurity.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    public BlogService blogService;

    @RequestMapping
    public ModelAndView list(Model model){
        model.addAttribute("blogsList",blogService.getBlogs());
        return new ModelAndView("blogs/list","blogModel",model);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model){
        blogService.deleteBlog(id);
        model.addAttribute("blogsList",blogService.getBlogs());
        return new ModelAndView("blogs/list","blogModel",model);
    }
}
