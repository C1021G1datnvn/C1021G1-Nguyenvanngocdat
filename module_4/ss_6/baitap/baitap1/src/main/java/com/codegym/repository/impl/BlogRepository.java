package com.codegym.repository.impl;


import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> selectAll() {
        TypedQuery<Blog> typedQuery = entityManager.createQuery("select b from Blog b", Blog.class);
        return typedQuery.getResultList();
    }

    @Override
    public void create(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void delete(Blog blog) {
        entityManager.remove(blog);
    }

    @Override
    public void edit(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public Blog selectById(Long id) {
        TypedQuery<Blog> typedQuery = entityManager.createQuery("select b from Blog b where b.id=:id", Blog.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }
}
