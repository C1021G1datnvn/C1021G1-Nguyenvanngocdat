package com.codegym.baitap1.service.impl;


import com.codegym.baitap1.model.Blog;
import com.codegym.baitap1.repository.IBlogRepository;
import com.codegym.baitap1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository repository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        repository.delete(blog);
    }

    @Override
    public Blog findById(Long id) {
       return repository.findById(id).get();
    }

//    @Override
//    public List<Blog> findBlogByHeaderContains(String header) {
//        return repository.findBlogByHeaderContains(header);
//    }

}
