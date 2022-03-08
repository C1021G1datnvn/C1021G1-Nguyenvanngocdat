package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> selectAll();
    void create(Blog blog);
    void delete(Blog blog);
    void edit(Blog blog);
    Blog selectById(Long id);
}
