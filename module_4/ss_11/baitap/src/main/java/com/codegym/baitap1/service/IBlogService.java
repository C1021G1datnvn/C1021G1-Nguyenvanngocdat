package com.codegym.baitap1.service;

import com.codegym.baitap1.model.Blog;


import java.util.List;
import java.util.Optional;

public interface IBlogService<T> {
    List<Blog> findAll();
    void save(Blog blog);
    void remove(Long id);
    Optional<T> findById(Long id);
//    List<Blog> findBlogByHeaderContains(String header);
}
