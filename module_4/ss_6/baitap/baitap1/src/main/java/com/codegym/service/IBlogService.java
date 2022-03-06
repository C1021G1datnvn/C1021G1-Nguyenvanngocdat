package com.codegym.service;


import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> selectAll();
    void create(Blog blog);
    void delete(Blog blog);
    void edit(Blog blog);
    Blog selectById(Long id);
}
