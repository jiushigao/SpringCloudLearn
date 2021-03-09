package com.example.springcloudsecurity.service.impl;

import com.example.springcloudsecurity.bean.Blog;
import com.example.springcloudsecurity.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("blogService")
public class BlogServiceImpl implements BlogService {
    List<Blog> list = new ArrayList<Blog>();

    public BlogServiceImpl() {
        list.add(new Blog(1l,"blog1","hahahahha"));
        list.add(new Blog(2l,"blog2","hehehehheh"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(Long id) {
        Iterator<Blog> iterator = list.iterator();
        while (iterator.hasNext()){
            if(id==iterator.next().getId()){
                iterator.remove();
                break;
            }
        }
     }
}
