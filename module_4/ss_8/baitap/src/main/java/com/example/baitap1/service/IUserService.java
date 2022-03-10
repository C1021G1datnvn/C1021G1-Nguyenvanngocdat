package com.example.baitap1.service;


import com.example.baitap1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    void save(User user);
//    User findByIdUser(Long id);
    Optional<User> findById(Long id);
}
