package com.example.baitap1.repository;


import com.example.baitap1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
//    User findByIdUser(Long id);
}
