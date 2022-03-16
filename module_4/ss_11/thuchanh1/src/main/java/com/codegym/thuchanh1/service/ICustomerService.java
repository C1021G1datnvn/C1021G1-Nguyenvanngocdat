package com.codegym.thuchanh1.service;

import java.util.Optional;

public interface ICustomerService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
