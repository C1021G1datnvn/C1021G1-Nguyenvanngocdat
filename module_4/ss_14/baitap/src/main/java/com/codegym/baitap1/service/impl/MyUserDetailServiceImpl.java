package com.codegym.baitap1.service.impl;

import com.codegym.baitap1.model.MyUserDetail;
import com.codegym.baitap1.model.User;
import com.codegym.baitap1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Tên đăng nhập không tồn tại.Vui lòng thử lại.");
        }
        return new MyUserDetail(user);
    }
}
