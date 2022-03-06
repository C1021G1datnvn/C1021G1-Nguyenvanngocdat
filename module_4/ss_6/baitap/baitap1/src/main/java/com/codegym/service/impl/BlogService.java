package com.codegym.service.impl;


import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> selectAll() {
        return blogRepository.selectAll();
    }

    @Override
    public void create(Blog blog) {
        blogRepository.create(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.edit(blog);
    }

    @Override
    public Blog selectById(Long id) {
        return blogRepository.selectById(id);

    }
}
