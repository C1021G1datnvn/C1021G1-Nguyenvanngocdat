package com.example.baitap1.service.impl;


import com.example.baitap1.model.User;
import com.example.baitap1.repository.IUserRepository;
import com.example.baitap1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

//    @Override
//    public User findByIdUser(Long id) {
//        return userRepository.findByIdUser(id);
//    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
