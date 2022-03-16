package com.codegym.baitap1.repository;


import com.codegym.baitap1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    List<Blog> findBlogByHeaderContains(String header);
}
