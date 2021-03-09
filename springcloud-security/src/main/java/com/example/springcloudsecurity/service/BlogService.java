package com.example.springcloudsecurity.service;

import com.example.springcloudsecurity.bean.Blog;

import java.util.List;

public interface BlogService {

    public List<Blog> getBlogs();

    public void deleteBlog(Long id);
}
