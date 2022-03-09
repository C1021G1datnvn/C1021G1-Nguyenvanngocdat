package com.codegym.baitap1.service;

import com.codegym.baitap1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
    void remove(Blog blog);
    Blog findById(Long id);
//    List<Blog> findBlogByHeaderContains(String header);
}
